package wenge.com.testkotlin.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import wenge.com.testkotlin.R
import wenge.com.testkotlin.domian.commands.RequestForecastCommand
import wenge.com.testkotlin.domian.model.ForecastList
import wenge.com.testkotlin.extensions.DelegatesExt
import wenge.com.testkotlin.extensions.toDateString
import wenge.com.testkotlin.ui.adapter.RvAdapter


class MainActivity : AppCompatActivity(), ToolbarManager {

    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    val ZIP_CODE = "zipCode"
    val DEFAULT_ZIP = 94043L
    val zipCode: Long by DelegatesExt.preference(this, ZIP_CODE, DEFAULT_ZIP)

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
        initToolbar()

        fList.layoutManager = LinearLayoutManager(this)
        attachToScroll(fList)

//        /**
//         * 线程切换
//         */
//        doAsync {
//            val url: String = "http://samples.openweathermap.org/data/2.5/forecast/daily?id=524901&appid=b1b15e88fa797225412429c1c50c122a1"
//
//            val forecastList = RequestDayForecastCommand(url).execute()        //获取项目所需的实体对象
//            uiThread {
////                /**
////                 * ForecastList ：数据源
////                 * OnItemClickListener：监听器
////                 */
//////                rvList.adapter = RvAdapter(forecastList,this@MainActivity)
//
//                fList.adapter = RvAdapter(forecastList){toast(it.date.toString())}   //相当于 rvList.setAdapter(new RvAdapter(forecastList))
//            }
//        }

    }

    override fun onResume() {
        super.onResume()
        loadForecast()
    }


    private fun loadForecast() = async(UI) {
        val result = bg { RequestForecastCommand(zipCode).execute() }
        updateUI(result.await())

    }

    private fun updateUI(weekForecast: ForecastList) {
        fList.adapter = RvAdapter(weekForecast) {
            toast(it.date.toDateString())
            startActivity<DetialActivity>(
                    DetialActivity.ID to it.id,
                    DetialActivity.CITY_NAME to weekForecast.city)
        }
        toolbarTitle = "${weekForecast.city} (${weekForecast.country})"
    }

}


