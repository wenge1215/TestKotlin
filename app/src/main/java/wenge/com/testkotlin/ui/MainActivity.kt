package wenge.com.testkotlin.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import android.widget.Toast
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import wenge.com.testkotlin.R
import wenge.com.testkotlin.domian.commands.RequestForecastCommand
import wenge.com.testkotlin.ui.adapter.RvAdapter

class MainActivity : AppCompatActivity(){

//    /**
//     * 实现点击事件的接口
//     */
//    override fun invoke(forecast: Forecast) {
//        toast(forecast.date)
//    }

    /**
     * 扩展属性
     */
    public var TextView.text: CharSequence
        get() = getText()
        set(value) = setText(value)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val rvList = findViewById<RecyclerView>(R.id.rv_list)

        val rvList = find<RecyclerView>(R.id.rv_list)
        rvList.layoutManager = LinearLayoutManager(this);
//        rvList.adapter = RvAdapter(items)

        /**
         * 线程切换
         */
        doAsync {
            val url: String = "http://samples.openweathermap.org/data/2.5/forecast/daily?id=524901&appid=b1b15e88fa797225412429c1c50c122a1"

            val forecastList = RequestForecastCommand(url).execute()        //获取项目所需的实体对象
            uiThread {
//                /**
//                 * ForecastList ：数据源
//                 * OnItemClickListener：监听器
//                 */
////                rvList.adapter = RvAdapter(forecastList,this@MainActivity)
                rvList.adapter = RvAdapter(forecastList){toast(it.date)}   //相当于 rvList.setAdapter(new RvAdapter(forecastList))
            }
        }
    }








    fun toast1(message: String, length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, length).show()
    }


    fun niceToast(message: String,
                  tag: String = javaClass.simpleName,
                  length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, "[$localClassName] $message", length).show()
    }
}


