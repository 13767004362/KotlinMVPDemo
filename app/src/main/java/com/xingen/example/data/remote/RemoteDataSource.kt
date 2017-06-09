package com.xingen.example.data.remote

import com.xingen.example.data.DouBanService
import com.xingen.example.data.MovieList
import com.xingen.example.utlis.OkHttpProvider

import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Observable
import rx.Subscriber
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by ${新根} on 2017/6/8.
 * blog ：http://blog.csdn.net/hexingen
 */
object RemoteDataSource{
    val baseURL="https://api.douban.com/v2/movie/"
    val retrofit:Retrofit by lazy {
        Retrofit.Builder().baseUrl(baseURL)
                .client(OkHttpProvider.createOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
    }
    var douBanService= retrofit.create(DouBanService::class.java)

    fun movieList(subscriber:Subscriber<List<MovieList.Movie>>):Subscription{
        val url="search"
        var map= hashMapOf("q" to "张艺谋" )
         var result= douBanService.movieList(url,map).flatMap {
            item: MovieList ->Observable.just(item.subjects)
        }.subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber)
        return result
    }
}