package wenge.com.testkotlin.net

import android.util.Log
import com.google.gson.Gson
import wenge.com.testkotlin.data.server.ForecastResult
import java.net.URL

/**
 * Created by WENGE on 2017/8/17.
 * 备注：网络请求
 */


public class Request(val url: String) {
    /**
     * 发起网络请求
     */
    public fun run() {
        val jsonString = URL(url).readText()
        Log.w("Request", jsonString)
    }

    /**
     * 执行网络请求，并将结果转换为实体对象
     */
    fun execute(): ForecastResult {
        val forecastJsonStr = URL(url).readText()
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
    }

}
