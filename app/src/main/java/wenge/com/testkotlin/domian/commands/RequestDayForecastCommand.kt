package wenge.com.testkotlin.domian.commands

import wenge.com.testkotlin.data.server.ServerDataMapper
import wenge.com.testkotlin.domian.model.ForecastList
import wenge.com.testkotlin.net.Request

/**
 * Created by WENGE on 2017/8/18.
 * 备注：请求网络，并将结果转换为最终对象
 */

class RequestForecastCommand(val url: String) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = Request(url)
        return ServerDataMapper().convertFromDataModel( //将数据装换为指定类型
                forecastRequest.execute()                //请求网络，获取数据
        )
    }
}