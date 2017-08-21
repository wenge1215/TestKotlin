package wenge.com.testkotlin.domian.commands

import wenge.com.testkotlin.domian.model.Forecast


/**
 * Created by WENGE on 2017/8/17.
 * 备注：只要返回值为接口类型，就会默认实现接口中的方法 ：Command<T>
 */
public interface Command<T> {
    fun execute() : T
}



