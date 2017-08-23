package wenge.com.testkotlin.data.server

import com.antonioleiva.weatherapp.domain.datasource.ForecastDataSource
import wenge.com.testkotlin.data.db.ForecastDB
import wenge.com.testkotlin.domian.model.ForecastList


/**
 * Created by WENGE on 2017/8/18.
 * 备注：
 */

class ForecastServer(val dataMapper: ServerDataMapper = ServerDataMapper(),
                     val forecastDb: ForecastDB = ForecastDB()) : ForecastDataSource {

    override fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList? {
        val result = ForecastByZipCodeRequest(zipCode).execute()        //获取天气数据
        val converted = dataMapper.convertToDomain(zipCode, result)     //转换数据
        forecastDb.saveForecast(converted)                              //将数据保存到数据库
        return forecastDb.requestForecastByZipCode(zipCode, date)       //返回数据
    }

    override fun requestDayForecast(id: Long) = throw UnsupportedOperationException()
}
