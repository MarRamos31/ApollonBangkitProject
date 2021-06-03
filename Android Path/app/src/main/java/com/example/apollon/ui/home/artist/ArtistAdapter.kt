package com.example.apollon.ui.home.artist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apollon.R

class ArtistAdapter(val listArtist: ArrayList<ArtistItem>): RecyclerView.Adapter<ArtistAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val image: ImageView = itemView.findViewById(R.id.iv_artists)
        val nama: TextView = itemView.findViewById(R.id.nama_artis)
        val genre: TextView = itemView.findViewById(R.id.genre_nya)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.artist_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView.context).load(listArtist[position].gambar).circleCrop().into(holder.image)
        holder.nama.text =   listArtist[position].nama
        holder.genre.text = listArtist[position].genre
    }

    override fun getItemCount(): Int {
        return listArtist.size
    }
}