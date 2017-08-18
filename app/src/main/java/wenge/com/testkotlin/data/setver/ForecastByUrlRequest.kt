package wenge.com.testkotlin.data.setver

import com.google.gson.Gson
import java.net.URL

/**
 * Created by WENGE on 2017/8/18.
 * 备注：
 */


class ForecastByUrlRequest(val url: String, val gson: Gson = Gson()) {

    fun execute(): ForecastResult {
        val jsonString = URL(url).readText()
        return gson.fromJson(jsonString, ForecastResult::class.java)
    }
}