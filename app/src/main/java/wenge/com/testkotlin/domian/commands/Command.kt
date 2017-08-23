package wenge.com.testkotlin.domian.commands


/**
 * Created by WENGE on 2017/8/17.
 * 备注：
 */
public interface Command<T> {
    fun execute() : T
}



