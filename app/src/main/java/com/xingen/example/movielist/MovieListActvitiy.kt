package com.xingen.example.movielist

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.xingen.example.R


class MovieListActvitiy : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movielist)
        var view=MovieListFragment.instance
        MovieListPresenter(view)
        supportFragmentManager.beginTransaction().add(R.id.movielist_content_layout,view,MovieListFragment.Tag).commit()
    }
}
