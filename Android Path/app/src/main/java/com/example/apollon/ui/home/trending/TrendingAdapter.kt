package com.example.apollon.ui.home.trending

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apollon.R

class TrendingAdapter(val listTrending: ArrayList<TrendingItem>): RecyclerView.Adapter<TrendingAdapter.ViewHolder>()  {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val image: ImageView = itemView.findViewById(R.id.iv_trending)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.trending_item,parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView.context).load(listTrending[position].image).into(holder.image)
//        Glide.with(holder.itemView.context).load(listTrending[position].image).centerCrop().into(holder.image)
    }

    override fun getItemCount(): Int {
        return listTrending.size
    }
}