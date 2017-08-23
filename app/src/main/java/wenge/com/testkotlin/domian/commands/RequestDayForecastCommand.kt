package wenge.com.testkotlin.domian.commands


import wenge.com.testkotlin.domian.datasource.ForecastProvider
import wenge.com.testkotlin.domian.model.Forecast

/**
 * Created by WENGE on 2017/8/18.
 * 备注：获取一天的天气
 */

class RequestDayForecastCommand(
        val id: Long,
        val forecastProvider: ForecastProvider = ForecastProvider()) :
        Command<Forecast> {

    override fun execute() = forecastProvider.requestForecast(id)
}