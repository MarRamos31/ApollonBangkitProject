package com.example.apollon.ui.home.bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apollon.R


class BundleAdapter(val listBundle: ArrayList<BundleItem>): RecyclerView.Adapter<BundleAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val bundlePic : ImageView = itemView.findViewById(R.id.bundle_pic)
        val bundleName: TextView = itemView.findViewById(R.id.bundle_name)
        val bundlePrice: TextView = itemView.findViewById(R.id.bundle_price)
        val liked: ImageView = itemView.findViewById(R.id.like_bundle)
        val added: ImageView = itemView.findViewById(R.id.add_bundle)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.bundle_item,parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView.context).load(listBundle[position].picBundle).into(holder.bundlePic)
        holder.bundleName.text =   listBundle[position].nameBundle
        holder.bundlePrice.text =   listBundle[position].priceBundle
        Glide.with(holder.itemView.context).load(listBundle[position].like).into(holder.liked)
        Glide.with(holder.itemView.context).load(listBundle[position].add).into(holder.added)

    }

    override fun getItemCount(): Int {
        return listBundle.size
    }
}