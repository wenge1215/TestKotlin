package wenge.com.testkotlin.data.db

import wenge.com.testkotlin.domian.model.Forecast
import wenge.com.testkotlin.domian.model.ForecastList

/**
 * Created by WENGE on 2017/8/22.
 * 备注：将数据映射到时数据库
 */
 class DBDateMapper{
    fun convertFromDomain(forecast: ForecastList) = with(forecast) {
        val daily = dailyForecast.map { convertDayFromDomain(id, it) }
        CityForecast(id, city, country, daily)
    }

    private fun convertDayFromDomain(cityId: Long, forecast: Forecast) = with(forecast) {
        DayForecast(date, description, high, low, iconUrl, cityId)
    }

    /**
     * 将数据映射到数据库
     */
    fun convertToDomain(forecast: CityForecast) = with(forecast) {
        val daily = dailyForecast.map { convertDayToDomain(it) }
        ForecastList(_id, city, country, daily)
    }

    fun convertDayToDomain(dayForecast: DayForecast) = with(dayForecast) {
        Forecast(_id, date , description, high, low, iconUrl)
    }

}

