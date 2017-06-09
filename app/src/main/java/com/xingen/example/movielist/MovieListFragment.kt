package com.xingen.example.movielist

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.xingen.example.R
import com.xingen.example.data.MovieList
import kotlinx.android.synthetic.main.fragment_movielist.view.*

/**
 * Created by ${新根} on 2017/6/8.
 * blog ：http://blog.csdn.net/hexingen
 */
class MovieListFragment : Fragment(), MovieListConstract.View {
    lateinit var presenters: MovieListConstract.Presenter
    lateinit var dialog: ProgressDialog
    lateinit var rootView: View
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_movielist, container, false)
        return rootView
    }

    override fun onResume() {
        super.onResume()
        presenters.subscribe()
    }

    override fun onPause() {
        super.onPause()
        presenters.unsubscribe()
    }

    override fun setPresenter(presenter: MovieListConstract.Presenter) {
        this.presenters = presenter
    }

    override fun showToast(msg: String) {
        Toast.makeText(activity.applicationContext, msg, Toast.LENGTH_SHORT).show()
    }

    /**
     * 加载数据
     */
    override fun loadMovie(list: List<MovieList.Movie>) {
        var recyclerView = rootView.movieList_recyclverView
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = MovieListAdapter(activity, list)
    }

    override fun showDialog() {
        dialog = ProgressDialog(activity)
        dialog.show()
    }

    override fun cancleDialog() {
        if (dialog != null && dialog.isShowing) {
            dialog.cancel()
        }
    }

    companion object {
        val instance = MovieListFragment()//静态对象
        val Tag = MovieListFragment::class.java.javaClass.simpleName
    }
}