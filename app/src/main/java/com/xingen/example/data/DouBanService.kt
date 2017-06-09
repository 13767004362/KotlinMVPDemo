package com.xingen.example.data


import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap
import rx.Observable

/**
 * Created by ${新根} on 2017/6/8.
 * blog ：http://blog.csdn.net/hexingen
 */
interface DouBanService {
    /**
     *     这里返回一个Observable，用于RxJava结合使用
     */
    @GET("{path}")
    fun movieList(@Path("path") path:String, @QueryMap options: Map<String,String> ):Observable<MovieList>
}