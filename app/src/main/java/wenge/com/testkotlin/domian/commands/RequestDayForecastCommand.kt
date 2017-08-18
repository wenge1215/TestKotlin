package wenge.com.testkotlin.domian.commands

import wenge.com.testkotlin.data.setver.ServerDataMapper
import wenge.com.testkotlin.domian.model.ForecastList
import wenge.com.testkotlin.net.Request

/**
 * Created by WENGE on 2017/8/18.
 * 备注：
 */

class RequestForecastCommand(val url: String) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = Request(url)
        return ServerDataMapper().convertFromDataModel(
                forecastRequest.execute())

    }
}