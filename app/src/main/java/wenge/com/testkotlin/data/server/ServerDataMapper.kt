package wenge.com.testkotlin.data.server


import wenge.com.testkotlin.domian.model.ForecastList
import java.text.DateFormat
import java.util.*
import wenge.com.testkotlin.domian.model.Forecast as ModelForecast      //给相同的对象名指定别名

/**
 * Created by WENGE on 2017/8/18.
 * 备注：将实体对象的属性转换为指定类型
 */



public class ServerDataMapper {
    fun convertFromDataModel(forecast: ForecastResult): ForecastList {
        return ForecastList(forecast.city.name, forecast.city.country,
                convertForecastListToDomain(forecast.list))
    }
    fun convertForecastListToDomain(list:List<Forecast>):List<ModelForecast>{
        return list.map { convertForecastItemToDomain(it)}
    }

    /**
     * 将网络请求的对象装换为所需对象
     */
    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(convertDate(forecast.dt),
                forecast.weather[0].description, forecast.temp.max.toInt(),
                forecast.temp.min.toInt(), generateIconUrl(forecast.weather[0].icon))
    }
    private fun convertDate(date: Long): String {  //格式时间
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date * 1000)
    }

    /**
     * 拼接icon地址
     */
    private fun generateIconUrl(iconCode: String) = "http://openweathermap.org/img/w/$iconCode.png"
}
