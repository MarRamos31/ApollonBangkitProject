package com.example.apollon.ui.home.milih

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apollon.R
import com.example.apollon.ui.home.trending.TrendingAdapter
import com.example.apollon.ui.home.trending.TrendingItem

class MilihAdapter(val listMilih: ArrayList<MilihItem>): RecyclerView.Adapter<MilihAdapter.ViewHolder>() {
    class ViewHolder(itemV: View): RecyclerView.ViewHolder(itemV) {

        val milih_gambar: ImageView = itemV.findViewById(R.id.shop_1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.muncul_item,parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView.context).load(listMilih[position].milih).circleCrop().into(holder.milih_gambar)
    }

    override fun getItemCount(): Int {
        return listMilih.size
    }
}