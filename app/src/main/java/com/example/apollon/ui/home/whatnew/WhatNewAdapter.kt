package com.example.apollon.ui.home.whatnew

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apollon.R

class WhatNewAdapter(val whattNew: ArrayList<WhatNewItem>):RecyclerView.Adapter<WhatNewAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val image: ImageView = itemView.findViewById(R.id.gambarnya)
        val nmaArtist: TextView = itemView.findViewById(R.id.namapenyanyi)
        val nmaLagu: TextView = itemView.findViewById(R.id.namalaguu)
        val critaLagu: TextView = itemView.findViewById(R.id.crtlagu)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.what_new_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView.context).load(whattNew[position].gambar).circleCrop().into(holder.image)
        holder.nmaArtist.text = whattNew[position].namaArtist
        holder.nmaLagu.text = whattNew[position].namaLagu
        holder.critaLagu.text = whattNew[position].ceritaLagu
    }

    override fun getItemCount(): Int {
        return whattNew.size
    }
}