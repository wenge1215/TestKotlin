package wenge.com.testkotlin.domian.datasource

import com.antonioleiva.weatherapp.domain.datasource.ForecastDataSource
import wenge.com.testkotlin.data.db.ForecastDB
import wenge.com.testkotlin.data.server.ForecastServer
import wenge.com.testkotlin.domian.model.Forecast
import wenge.com.testkotlin.domian.model.ForecastList
import wenge.com.testkotlin.extensions.firstResult

/**
 * Created by WENGE on 2017/8/18.
 * 备注：天气的提供者
 */

class ForecastProvider(val sources: List<ForecastDataSource> = ForecastProvider.SOURCES) {
    companion object {
        val DAY_IN_MILLIS = 1000 * 60 * 60 * 24
        val SOURCES by lazy { listOf(ForecastDB(), ForecastServer()) }
    }

    fun requestByZipCode(zipCode: Long, days: Int): ForecastList = requestToSources {
        val res = it.requestForecastByZipCode(zipCode, todayTimeSpan())
        if (res != null && res.size >= days) res else null
    }

    fun requestForecast(id: Long): Forecast = requestToSources { it.requestDayForecast(id) }

    private fun todayTimeSpan() = System.currentTimeMillis() / DAY_IN_MILLIS * DAY_IN_MILLIS

    private fun <T : Any> requestToSources(
            f: (ForecastDataSource) -> T?): T = sources.firstResult { f(it) }

}
