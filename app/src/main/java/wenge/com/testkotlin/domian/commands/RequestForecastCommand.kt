package wenge.com.testkotlin.domian.commands;

import wenge.com.testkotlin.domian.datasource.ForecastProvider
import wenge.com.testkotlin.domian.model.ForecastList

/**
 * Created by WENGE on 2017/8/22.
 * 备注：
 */


class RequestForecastCommand(
        val zipCode: Long,
        val forecastProvider: ForecastProvider = ForecastProvider()) :
        Command<ForecastList> {

    companion object {
        val DAYS = 7
    }

    override fun execute() = forecastProvider.requestByZipCode(zipCode, DAYS)
}