package wenge.com.testkotlin.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import android.widget.Toast
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.uiThread
import wenge.com.testkotlin.R
import wenge.com.testkotlin.TestMach
import wenge.com.testkotlin.domian.commands.RequestForecastCommand
import wenge.com.testkotlin.ui.adapter.RvAdapter

class MainActivity : AppCompatActivity() {

    /**
     * 扩展属性
     */
    public var TextView.text: CharSequence
        get() = getText()
        set(value) = setText(value)


    private val items = listOf<String>(
            "Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/8",
            "Wed 6/25 - Cloudy - 22/17",
            "Thurs 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy - 21/10",
            "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
            "Sun 6/29 - Sunny - 20/7"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val rvList = findViewById<RecyclerView>(R.id.rv_list)

        val rvList = find<RecyclerView>(R.id.rv_list)
        rvList.layoutManager = LinearLayoutManager(this);
//        rvList.adapter = RvAdapter(items)

        val testMach = TestMach()
        val add = testMach.add(15, 25)
        println(add)

        /**
         * 线程切换
         */
        doAsync {
            val url: String = "http://samples.openweathermap.org/data/2.5/forecast/daily?id=524901&appid=b1b15e88fa797225412429c1c50c122a1"

            val forecastList = RequestForecastCommand(url).execute()
            uiThread {
                rvList.adapter = RvAdapter(forecastList)        //相当于setAdapter
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


