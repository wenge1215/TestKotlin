package com.tt.lvruheng.eyepetizer.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import wenge.com.testkotlin.R


/**
 * Created by lvruheng on 2017/7/6.
 */
class ImageLoadUtils {



    companion object {

        val options = RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.mipmap.ic_launcher_foreground)
                .placeholder(R.mipmap.ic_launcher_round)
                .centerCrop()


        fun display(context: Context, imageView: ImageView?, url: String) {
            if (imageView == null) {
                throw IllegalArgumentException("argument error")
            }
            Glide.with(context).load(url)
                    .apply(options)
                    .into(imageView)
        }

        fun displayHigh(context: Context, imageView: ImageView?, url: String) {
            if (imageView == null) {
                throw IllegalArgumentException("argument error")
            }
            options.format(DecodeFormat.PREFER_ARGB_8888)
            Glide.with(context)
                    .asBitmap()
                    .apply(options)
                    .load(url)
                    .into(imageView)


        }
    }

}