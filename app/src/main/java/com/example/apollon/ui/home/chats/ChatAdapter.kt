package com.example.apollon.ui.home.chats

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apollon.R

class ChatAdapter(val listChat: ArrayList<ChatItem>):RecyclerView.Adapter<ChatAdapter.ViewHolder>() {
    class ViewHolder(chatItem: View) : RecyclerView.ViewHolder(chatItem) {

        val gambarChat: ImageView = chatItem.findViewById(R.id.chat_photo)
        val namaChat: TextView = chatItem.findViewById(R.id.artist_chat_name)
        val isiChat: TextView = chatItem.findViewById(R.id.isi_chat)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val liat = LayoutInflater.from(parent.context).inflate(R.layout.chat_item, parent, false)
        return ViewHolder(liat)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView.context).load(listChat[position].dpArtist).into(holder.gambarChat)
        holder.namaChat.text =  listChat[position].namaChat
        holder.isiChat.text = listChat[position].isiChat
    }

    override fun getItemCount(): Int {
        return listChat.size
    }
}