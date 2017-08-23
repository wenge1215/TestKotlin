package wenge.com.testkotlin.domian.model


/**
 * Created by WENGE on 2017/8/18.
 * 备注：跟符合项目需求的对象实体（天气列表）
 */

data class ForecastList(val id: Long, val city: String, val country: String,
                        val dailyForecast: List<Forecast>) {

    val size: Int
        get() = dailyForecast.size

    operator fun get(position: Int) = dailyForecast[position]
}
//
//data class Forecast(val id: Long, val date: Long, val description: String, val high: Int,
//                    val low: Int,
//                    val iconUrl: String)
data class Forecast(val id: Long, val date: Long, val description: String, val high: Int,
                    val low: Int,
                    val iconUrl: String)
