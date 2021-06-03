package com.example.apollon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.apollon.ui.home.chats.ChatAdapter
import com.example.apollon.ui.home.chats.ChatItem

class ChatActivity : AppCompatActivity() {

    lateinit var keMain: ImageView
    private lateinit var rvChats: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        keMain = (findViewById(R.id.ke_main))

        keMain.setOnClickListener{
            val pindhKeMain = Intent(this@ChatActivity, BottomNavigation::class.java)
            startActivity(pindhKeMain)
        }

        rvChats = findViewById(R.id.chat_list)

        val listChat = arrayListOf<ChatItem>(
                ChatItem(R.drawable.sitha, "Sitha Marino", "Makasih!!!"),
                ChatItem(R.drawable.fathia, "Fathia Izzati", "Hahahaha, makasih"),
                ChatItem(R.drawable.alyssa, "Alyssa Isnan", "Bukan kupu - kupu malem haha"),
                ChatItem(R.drawable.rai, "Sitha Marino", "Bastiaan"),
                ChatItem(R.drawable.maia, "Sitha Marino", "Dhani"),
                ChatItem(R.drawable.pusa, "Sitha Marino", "Yeahh..."),
        )
        val chatAdapter = ChatAdapter(listChat)
        rvChats.adapter = chatAdapter

    }



}