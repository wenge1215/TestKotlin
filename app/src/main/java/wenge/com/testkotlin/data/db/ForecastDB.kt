package wenge.com.testkotlin.data.db

import com.antonioleiva.weatherapp.domain.datasource.ForecastDataSource
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select
import wenge.com.testkotlin.domian.model.ForecastList
import wenge.com.testkotlin.extensions.*
import java.util.*

/**
 * Created by WENGE on 2017/8/22.
 * 备注：数据库操作类
 */

class ForecastDB(val forecastOpenHelper: ForecastOpenHelper = ForecastOpenHelper.instance, val dateMapper: DBDateMapper = DBDateMapper()): ForecastDataSource {
    override fun requestForecastByZipCode(zipCode: Long, date: Long) = forecastOpenHelper.use {

        val dailyRequest = "${DayForecastTable.CITY_ID} = ? AND ${DayForecastTable.DATE} >= ?"
        val dailyForecast = select(DayForecastTable.NAME)
                .whereSimple(dailyRequest, zipCode.toString(), date.toString())
                .parseList { DayForecast(HashMap(it)) }

        val city = select(CityForecastTable.NAME)
                .whereSimple("${CityForecastTable.ID} = ?", zipCode.toString())
                .parseOpt { CityForecast(HashMap(it), dailyForecast) }


        city?.let { dateMapper.convertToDomain(it) }
    }

    override fun requestDayForecast(id: Long) = forecastOpenHelper.use {
        val forecast = select(DayForecastTable.NAME).byId(id).
                parseOpt { DayForecast(HashMap(it)) }

        forecast?.let { dateMapper.convertDayToDomain(it) }
    }

    fun saveForecast(forecast: ForecastList) = forecastOpenHelper.use {

        clear(CityForecastTable.NAME)
        clear(DayForecastTable.NAME)

        with(dateMapper.convertFromDomain(forecast)) {
            insert(CityForecastTable.NAME, *map.toVarargArray())
            dailyForecast.forEach { insert(DayForecastTable.NAME, *it.map.toVarargArray()) }
        }
    }


}
