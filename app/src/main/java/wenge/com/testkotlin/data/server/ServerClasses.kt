package wenge.com.testkotlin.data.server

/**
 * Created by WENGE on 2017/8/18.
 * 备注：
 */


/**
 * Created by WENGE on 2017/8/18.
 * 备注：天气的实体对象
 */

data class ForecastResult(val city: City, val cnt: Int, val cod: Int,
                          val message: Int, val list: List<Forecast>)

data class City(val id: Long, val country: String, val iso: String,
                val lat: Float, val lon: Float, val name: String,
                val population: Int, val type: String)

data class Forecast(val clouds: Int, val dug: Int, val dt: Long,
                    val humidity: Int, val pressure: Float, val show: Float,
                    val speed: Float, val temp: Temp, val weather: List<Weather>)

data class Temp(val day: Float, val max: Float, val min: Float,
                val morn: Float, val night: Float)

data class Weather(val id: Long, val icon: String,
                   val description: String, val main: String)