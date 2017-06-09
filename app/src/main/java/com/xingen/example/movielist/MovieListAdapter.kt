package com.xingen.example.movielist

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.xingen.example.R
import com.xingen.example.data.MovieList
import com.xingen.example.utlis.glide.GlideUtils
import kotlinx.android.synthetic.main.movielist_item.view.*

/**
 * Created by ${新根} on 2017/6/8.
 * blog ：http://blog.csdn.net/hexingen
 */
internal class MovieListAdapter(var context: Context, var list: List<MovieList.Movie>) : RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(View.inflate(parent.context, R.layout.movielist_item, null))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        GlideUtils.loadUrlImage(context,list[position].images.large,holder.imageView)
        holder.title_Tv.text=list[position].title
    }
    override fun getItemCount() = list.size
    internal class ViewHolder(rootView: View) : RecyclerView.ViewHolder(rootView) {
        /**
         * 这里使用Kotlin Android 扩展，省略了findViewById（）.
         * 在最上面导入了import kotlinx.android.synthetic.main.movielist_item.view.*
         */
        var imageView = rootView.movielist_item_iv
        var title_Tv= rootView.movielist_item_tv
    }
}