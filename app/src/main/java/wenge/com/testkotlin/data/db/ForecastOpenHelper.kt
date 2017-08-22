package wenge.com.testkotlin.data.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.ManagedSQLiteOpenHelper
import wenge.com.testkotlin.ui.App

/**
 * Created by WENGE on 2017/8/22.
 * 备注：创建数据库帮助类
 */


class ForecastOpenHelper(ctx: Context = App.instance) : ManagedSQLiteOpenHelper(ctx,ForecastOpenHelper.DB_NAME,null,ForecastOpenHelper.DB_VERSION) {
    /**
     * 相当于Java中的静态代码块
     */
    companion object {
        val DB_NAME = "forecast.db"
        val DB_VERSION = 1
        val instance by lazy { ForecastOpenHelper() }
    }
    override fun onCreate(p0: SQLiteDatabase?) {

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

}

