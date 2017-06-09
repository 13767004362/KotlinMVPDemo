package com.xingen.example.utlis.glide

import android.content.Context
import android.widget.ImageView

/**
 * Created by ${新根} on 2017/6/8.
 * blog ：http://blog.csdn.net/hexingen
 *
 */
internal class CircularBitmapImageViewTarget(var context: Context, var imageView: ImageView): com.bumptech.glide.request.target.BitmapImageViewTarget(imageView){
    /**
     * 绘制圆角的Bitmap
     */
   override fun setResource(bitmap: android.graphics.Bitmap?) {
          var bitmapDrawable= android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory.create(context.resources,bitmap)
          bitmapDrawable.isCircular=true
          imageView.setImageDrawable(bitmapDrawable)
    }
}