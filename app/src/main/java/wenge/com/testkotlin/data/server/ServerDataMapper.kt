package wenge.com.testkotlin.data.server


import wenge.com.testkotlin.domian.model.ForecastList
import java.text.DateFormat
import java.util.*
import wenge.com.testkotlin.domian.model.Forecast as ModelForecast

/**
 * Created by WENGE on 2017/8/18.
 * 备注：
 */



public class ServerDataMapper {
    fun convertFromDataModel(forecast: ForecastResult): ForecastList {
        return ForecastList(forecast.city.name, forecast.city.country,
                convertForecastListToDomain(forecast.list))
    }
    fun convertForecastListToDomain(list:List<Forecast>):List<ModelForecast>{
        return list.map { convertForecastItemToDomain(it)}
    }
    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(convertDate(forecast.dt),
                forecast.weather[0].description, forecast.temp.max.toInt(),
                forecast.temp.min.toInt(), generateIconUrl(forecast.weather[0].icon))
    }
    private fun convertDate(date: Long): String {  //格式时间
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date * 1000)
    }

    private fun generateIconUrl(iconCode: String) = "http://openweathermap.org/img/w/$iconCode.png"
}
