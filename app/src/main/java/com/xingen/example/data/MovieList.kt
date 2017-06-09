package com.xingen.example.data

/**
 * Created by ${新根} on 2017/6/8.
 * blog ：http://blog.csdn.net/hexingen
 */
data  class MovieList(var subjects:List<Movie>){
    data class Movie(var year:String,var title:String,var  images: Images){
        data class Images(var small:String,var large:String)
    }
}