package wenge.com.testkotlin

import android.util.Log
import wenge.com.testkotlin.domian.commands.Command

/**
 * Created by WENGE on 2017/8/17.
 * 备注：
 */


class TestMach {// 如果要传参，可以直接在类名后面加括号 class TestMash(a : Int, b :Int)

    /**
     * 相当于Java的构造函数
     */
    init {
        Log.e("TestMach", "执行初始化操作")
    }

    fun add(a: Int, b: Int): Int {  //参数名在前，类型在后
        Log.e("TestMach", "调用add方法")
        return a + b
    }

    /**
     *  变量
     * val 静态变量 代表Java中的被fine修饰的变量
     * var 可变变量 和Java 中的普通变量一样
     */

    val a: Int = 7;
    var b: Int = 66

    //将数字字符转变为int，没有类型强制转换
    var c: Char = '1'
    var d: Int = c.toInt()

    val s = "wxample"

    fun tsetf() {
        for (c in s) {
            println(c)
        }
    }


    fun test() {
//        a = 4       //（val）一旦符值就不能再改变了
        b = 4       //（var） 被符值后还可以动态修改
    }
}



class Test : Command<String> {
    override fun execute(): String {
        return ""
    }
}


