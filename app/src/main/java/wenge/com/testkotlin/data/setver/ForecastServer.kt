package wenge.com.testkotlin.data.setver

import com.antonioleiva.weatherapp.domain.datasource.ForecastDataSource
import wenge.com.testkotlin.domian.model.ForecastList


/**
 * Created by WENGE on 2017/8/18.
 * 备注：
 */

class ForecastServer(val dataMapper: ServerDataMapper = ServerDataMapper()):ForecastDataSource{
    override fun requestForecastByUrl(url: String): ForecastList? {
        val forecastResult = ForecastByUrlRequest(url).execute()
        val converted = dataMapper.convertFromDataModel(forecastResult)

        return converted
    }

}
