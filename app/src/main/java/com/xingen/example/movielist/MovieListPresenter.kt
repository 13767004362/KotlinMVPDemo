package com.xingen.example.movielist

import com.xingen.example.data.MovieList
import com.xingen.example.data.remote.RemoteDataSource
import rx.Subscriber
import rx.subscriptions.CompositeSubscription

/**
 * Created by ${新根} on 2017/6/8.
 * blog ：http://blog.csdn.net/hexingen
 */
class MovieListPresenter(var view: MovieListConstract.View, var compositeSubscription: CompositeSubscription = defaultCompositeSubscription) : MovieListConstract.Presenter {
    init {
        view.setPresenter(this)
    }
    override fun subscribe() {
        view.showDialog()
        excuteTask()
    }
    fun excuteTask() {
      var  disposable=RemoteDataSource.movieList(object :Subscriber<List<MovieList.Movie>>() {
            override fun onNext(t: List<MovieList.Movie>) = view.loadMovie(t)
            override fun onError(e: Throwable) {
                view.showToast(e.toString())
                view.cancleDialog()
            }
          override fun onCompleted() {
              view.showToast("加载完成")
              view.cancleDialog()
          }
      })
        this.compositeSubscription.add(disposable)
    }
    override fun unsubscribe() {
        view.cancleDialog()
        compositeSubscription.clear()
    }
    companion object {
        //默认的值
        val defaultCompositeSubscription get() = CompositeSubscription()
    }
}