package com.antonioleiva.weatherapp.domain.datasource

import wenge.com.testkotlin.domian.model.Forecast
import wenge.com.testkotlin.domian.model.ForecastList

/**
 * 获取天气数据的接口
 */
interface ForecastDataSource {
    /**
     * 获取指定日期天气
     */
    fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList?

    /**
     * 获取一天的天气数据
     */
    fun requestDayForecast(id: Long): Forecast?

}