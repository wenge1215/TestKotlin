package wenge.com.testkotlin.ui

import android.content.Context
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.TextView
import com.tt.lvruheng.eyepetizer.utils.ImageLoadUtils
import kotlinx.android.synthetic.main.activity_detial.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.ctx
import org.jetbrains.anko.find
import wenge.com.testkotlin.R
import wenge.com.testkotlin.domian.commands.RequestDayForecastCommand
import wenge.com.testkotlin.domian.model.Forecast
import wenge.com.testkotlin.extensions.textColor


/**
 * Created by WENGE on 2017/8/23.
 * 备注：
 */


class DetialActivity: AppCompatActivity(),ToolbarManager {
    override val toolbar: Toolbar
        get() = find<Toolbar>(R.id.toolbar)

    companion object {
        val ID = "DetailActivity:id"
        val CITY_NAME = "DetailActivity:cityName"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detial)
        toolbarTitle = intent.getStringExtra(CITY_NAME)

        enableHomeAsUp { onBackPressed() }

        async(UI) {
            val result = bg { RequestDayForecastCommand(intent.getLongExtra(ID, -1)).execute() }
            bindForecast(result.await())
        }
    }

    private fun bindForecast(forecast: Forecast) = with(forecast) {

        ImageLoadUtils.display(ctx,icon,iconUrl)
//        toolbar.subtitle = date.toDateString(java.text.DateFormat.FULL)
        weatherDescription.text = description
        bindWeather(high to maxTemperature, low to minTemperature)
    }

    private fun bindWeather(vararg views: Pair<Int, TextView>) = views.forEach {
        it.second.text = "${it.first}º"
        it.second.textColor = color(when (it.first) {       //when 相当于switch eras
            in -50..0 -> android.R.color.holo_red_dark
            in 0..15 -> android.R.color.holo_orange_dark
            else -> android.R.color.holo_green_dark
        })
    }

    fun Context.color(res: Int): Int = ContextCompat.getColor(this, res)
}



