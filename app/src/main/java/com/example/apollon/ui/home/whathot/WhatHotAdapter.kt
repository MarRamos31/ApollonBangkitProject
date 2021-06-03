package com.example.apollon.ui.home.whathot

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apollon.R
import com.example.apollon.ui.home.bundle.BundleAdapter
import com.example.apollon.ui.home.bundle.BundleItem

class WhatHotAdapter(val listHot: ArrayList<WhatHotItem>): RecyclerView.Adapter<WhatHotAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val hotPic : ImageView = itemView.findViewById(R.id.what_hot_pic)
        val hotName: TextView = itemView.findViewById(R.id.what_hot_name)
        val hotPrice: TextView = itemView.findViewById(R.id.what_hot_price)
        val hot_liked: ImageView = itemView.findViewById(R.id.what_hot_like)
        val hot_added: ImageView = itemView.findViewById(R.id.what_hot_plus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.what_hot_item,parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView.context).load(listHot[position].picHot).into(holder.hotPic)
        holder.hotName.text =   listHot[position].nameHot
        holder.hotPrice.text =   listHot[position].priceHot
        Glide.with(holder.itemView.context).load(listHot[position].likeHot).into(holder.hot_liked)
        Glide.with(holder.itemView.context).load(listHot[position].addHot).into(holder.hot_added)
    }

    override fun getItemCount(): Int {
        return listHot.size
    }
}