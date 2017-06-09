package com.xingen.example.movielist

import com.xingen.example.BasePresenter
import com.xingen.example.BaseView
import com.xingen.example.data.MovieList

/**
 * Created by ${新根} on 2017/6/8.
 * blog ：http://blog.csdn.net/hexingen
 */
interface MovieListConstract{
    interface Presenter:BasePresenter
    /***
     * 抽出Presenter对View的响应行为，在View接口中定义
     */
    interface View :BaseView<Presenter>{
        fun showToast(msg:String)//Toast提示
        fun loadMovie(list: List<MovieList.Movie>)//加载电影数据
        fun showDialog()//显示dialog
        fun cancleDialog()//取消dialog
    }
}
