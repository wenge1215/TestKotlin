package wenge.com.testkotlin.ui

import android.app.Application

/**
 * Created by WENGE on 2017/8/21.
 * 备注：
 */


class App : Application(){
    /**
     * 单例模式
     */
    companion object {
        public var instance: Application? = null
        fun instance() = instance !!
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}