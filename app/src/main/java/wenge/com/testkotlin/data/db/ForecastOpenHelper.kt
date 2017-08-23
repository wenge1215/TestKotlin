package wenge.com.testkotlin.data.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*
import wenge.com.testkotlin.ui.App

/**
 * Created by WENGE on 2017/8/22.
 * 备注：创建数据库帮助类
 */


class ForecastOpenHelper(ctx: Context = App.instance) : ManagedSQLiteOpenHelper(ctx, ForecastOpenHelper.DB_NAME, null, ForecastOpenHelper.DB_VERSION) {
    /**
     * 相当于Java中的静态代码块
     */
    companion object {
        val DB_NAME = "forecast.db"
        val DB_VERSION = 1
        val instance by lazy { ForecastOpenHelper() }  //lazy :懒加载
    }


    override fun onCreate(p0: SQLiteDatabase?) {
        /**
         * 创建数据库
         * 第一个参数是表的名称
         * 第二个参数，当是true的时候，创建之前会检查这个表是否存在。
         * 第三个参数是一个Pair类型的vararg参数。vararg也存在在Java中，这是一种在一个函数中传入联系很多相同类型        * 的参数。这个函数也接收一个对象数组。
         */
        p0!!.createTable(CityForecastTable.NAME, true,
                CityForecastTable.ID to INTEGER + PRIMARY_KEY, //创建id列并指定数据类型
                CityForecastTable.CITY to TEXT,
                CityForecastTable.COUNTRY to TEXT
        )

        p0!!.createTable(DayForecastTable.NAME, true,
                DayForecastTable.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                DayForecastTable.DATE to INTEGER,
                DayForecastTable.DESCRIPTION to TEXT,
                DayForecastTable.HIGH to INTEGER,
                DayForecastTable.LOW to INTEGER,
                DayForecastTable.ICON_URL to TEXT,
                DayForecastTable.CITY_ID to INTEGER
        )
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0!!.dropTable(CityForecastTable.NAME, true)
        p0!!.dropTable(DayForecastTable.NAME, true)
        onCreate(p0)
    }
}

