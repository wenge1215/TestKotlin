package wenge.com.testkotlin.data.db

/**
 * Created by WENGE on 2017/8/22.
 * 备注： 数据库Model
 * 属性直接映射到数据库中，反过来也一样
 */

class CityForecast(val map: MutableMap<String, Any?>, val dailyForecast: List<DayForecast>) {
    var _id: Long by map
    var city: String by map
    var country: String by map

    constructor(id: Long, city: String, country: String, dailyForecast: List<DayForecast>) : this(HashMap(), dailyForecast) {
        this._id = id
        this.city = city
        this.country = country
    }

}
//
//val NAME = "DayForecast"
//val ID = "_id"
//val DATE = "date"
//val DESCRIPTION = "description"
//val HIGH = "high"
//val LOW = "low"
//val ICON_URL = "iconUrl"
//val CITY_ID = "cityId"

class DayForecast(var map: MutableMap<String, Any?>) {
    var _id :Long by map
    var date :Long by map
    var description :String by map
    var high :Int by map
    var low :Int by map
    var iconUrl:String  by map
    var cityId: Long by map

    /**
     * 构造函数
     */
    constructor(date: Long, description: String, high: Int, low: Int, iconUrl: String, cityId: Long) : this(HashMap()) {
        this.date = date
        this.description = description
        this.high = high
        this.low = low
        this.iconUrl = iconUrl
        this.cityId = cityId
    }

}