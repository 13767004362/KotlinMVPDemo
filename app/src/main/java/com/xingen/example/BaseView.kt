package com.xingen.example

/**
 * Created by ${新根} on 2017/6/8.
 * blog ：http://blog.csdn.net/hexingen
 */
interface BaseView<T>{
    /**
     * 设置Presenter的方法
     */
    fun  setPresenter(presenter: T)
}