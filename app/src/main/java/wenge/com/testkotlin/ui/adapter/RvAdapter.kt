package wenge.com.testkotlin.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tt.lvruheng.eyepetizer.utils.ImageLoadUtils
import kotlinx.android.synthetic.main.layout_rv_item.view.*
import wenge.com.testkotlin.R
import wenge.com.testkotlin.domian.model.Forecast
import wenge.com.testkotlin.domian.model.ForecastList
import wenge.com.testkotlin.extensions.toDateString

/**
 * Created by WENGE on 2017/8/17.
 * 备注：
 */

class RvAdapter(val weekForecast: ForecastList, val itemClick: (Forecast) -> Unit) : RecyclerView.Adapter<RvAdapter.Viewholder>() {
    override fun onBindViewHolder(holder: Viewholder?, position: Int) {
        holder!!.bindForecast(weekForecast[position])
    }

    override fun getItemCount(): Int = weekForecast.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Viewholder {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.layout_rv_item, parent, false)
        return Viewholder(view, itemClick)
    }
    class Viewholder(view: View, val itemClick: (Forecast) -> Unit) : RecyclerView.ViewHolder(view) {
        /**
         * 控件与数据绑定
         * @parms:forecast 数据源
         */
        fun bindForecast(forecast: Forecast) {
            with(forecast){
                ImageLoadUtils.display(itemView.context, itemView.icon, iconUrl)
                itemView.date.text = date.toDateString()
                itemView.description.text = description
                itemView.maxTemperature.text = "${high.toString()}"
                itemView.minTemperature.text = "${low.toString()}"
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }
}
