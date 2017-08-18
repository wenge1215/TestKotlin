package com.antonioleiva.weatherapp.domain.datasource

import wenge.com.testkotlin.domian.model.ForecastList


interface ForecastDataSource {

    fun requestForecastByUrl(url: String): ForecastList?

}