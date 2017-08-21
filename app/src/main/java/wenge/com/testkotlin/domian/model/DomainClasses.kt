package wenge.com.testkotlin.domian.model


/**
 * Created by WENGE on 2017/8/18.
 * 备注：跟符合项目需求的对象实体（天气列表）
 */
data class ForecastList(val city: String, val country: String,
                        val dailyForecast: List<Forecast>) {
    fun size(): Int = dailyForecast.size
    operator fun get(position: Int) = dailyForecast[position]
}

data class Forecast(val date: String, val description: String, val high: Int,
                    val low: Int, val iconUrl: String)