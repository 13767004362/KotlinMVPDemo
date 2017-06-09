package com.xingen.example.utlis.glide;

import android.content.Context;
import android.widget.ImageView;

import com.xingen.example.GlideApp;
import com.xingen.example.R;



/**
 * Created by ${新根} on 2017/6/8.
 * blog ：http://blog.csdn.net/hexingen
 *
 *  GlideApp无法引用的解决方式：https://github.com/bumptech/glide/issues/1939
 *  在Kotlin编程中无法使用GlideApp的引用（Unresolved reference: GlideApp）,采取曲线救国的方式，java来编写
 */

public class GlideUtils {
    public static void loadUrlImage(Context context, String url, ImageView imageView){
        GlideApp.with(context).asBitmap().load(url).error(R.mipmap.ic_launcher).placeholder(R.mipmap.ic_launcher).into(new CircularBitmapImageViewTarget(context,imageView));
    }
}
