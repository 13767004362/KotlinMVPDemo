package com.xingen.example.utlis

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

/**
 * Created by ${新根} on 2017/6/8.
 * blog ：http://blog.csdn.net/hexingen
 */
internal class OkHttpProvider{
    companion object{
        /**
         * 自定义配置OkHttpClient
         */
        fun createOkHttpClient():OkHttpClient{
           var  builder=OkHttpClient.Builder()
            var  loggingInterceptor=HttpLoggingInterceptor()
            loggingInterceptor.level=HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(loggingInterceptor)
            return builder.build()
        }

    }
}