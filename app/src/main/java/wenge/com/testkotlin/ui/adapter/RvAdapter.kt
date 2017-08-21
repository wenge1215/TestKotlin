package wenge.com.testkotlin.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.tt.lvruheng.eyepetizer.utils.ImageLoadUtils
import org.jetbrains.anko.find
import wenge.com.testkotlin.R
import wenge.com.testkotlin.domian.model.Forecast
import wenge.com.testkotlin.domian.model.ForecastList

/**
 * Created by WENGE on 2017/8/17.
 * 备注：
 */

class RvAdapter(val weekForecast: ForecastList, val itemClick: RvAdapter.OnItemClickListener) : RecyclerView.Adapter<RvAdapter.Viewholder>() {
    override fun onBindViewHolder(holder: Viewholder?, position: Int) {
//        with(weekForecast.dailyForecast[position]) {
//            holder!!.textView.text="$date - $description - $high/$low"
//        }
//        with(weekForecast[position]) {
//            holder!!.textView.text = "$date - $description - $high/$low"
//        }

        holder!!.bindForecast(weekForecast[position])

    }

    override fun getItemCount(): Int = weekForecast.size()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Viewholder {
//        return Viewholder(TextView(parent!!.getContext()))
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.layout_rv_item, parent, false)
        return Viewholder(view, itemClick)
    }

    class Viewholder(view: View, val itemClick: OnItemClickListener) : RecyclerView.ViewHolder(view) {
        private val iconView: ImageView
        private val dateView: TextView
        private val descriptionView: TextView
        private val maxTemperatureView: TextView
        private val minTemperatureView: TextView

        /**
         * 初始化控件
         */
        init {
            iconView = view.find(R.id.icon)
            dateView = view.find(R.id.date)
            descriptionView = view.find(R.id.description)
            maxTemperatureView = view.find(R.id.maxTemperature)
            minTemperatureView = view.find(R.id.minTemperature)
        }

        /**
         * 控件与数据绑定
         * @parms:forecast 数据源
         */
        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                ImageLoadUtils.display(itemView.context, iconView, iconUrl)
                dateView.text = date
                descriptionView.text = description
                maxTemperatureView.text = "${high.toString()}"
                minTemperatureView.text = "${low.toString()}"
                itemView.setOnClickListener { itemClick(forecast) }
            }
        }
    }

    public interface OnItemClickListener {
        operator fun invoke(forecast: Forecast)
    }
}
