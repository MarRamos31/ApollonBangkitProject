package com.example.apollon.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.apollon.BottomNavigation
import com.example.apollon.R
import com.example.apollon.ui.home.artist.ArtistAdapter
import com.example.apollon.ui.home.artist.ArtistItem
import com.example.apollon.ui.home.chats.ChatAdapter
import com.example.apollon.ui.home.chats.ChatItem
import com.example.apollon.ui.home.trending.TrendingAdapter
import com.example.apollon.ui.home.trending.TrendingItem
import com.example.apollon.ui.home.whatnew.WhatNewAdapter
import com.example.apollon.ui.home.whatnew.WhatNewItem

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var rvTrending: RecyclerView
    private lateinit var rvArtist: RecyclerView
    private lateinit var rvWhatNew: RecyclerView

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvTrending = view.findViewById(R.id.rv_trending)
        rvArtist = view.findViewById(R.id.rv_artists)
        rvWhatNew = view.findViewById(R.id.rv_whatnew)

//        var arr = arrayOf(1,2,1,2,1,2,1)
//
//        BottomNavigation.interpreter.run(arr, BottomNavigation.resultArray)

        val listTrending = arrayListOf<TrendingItem>(
            TrendingItem(R.drawable.reality),
            TrendingItem(R.drawable.panturas),
            TrendingItem(R.drawable.rai),
        )
        val adapterTrending = TrendingAdapter(listTrending)
        rvTrending.adapter = adapterTrending


        val listArtist =  arrayListOf<ArtistItem>(
            ArtistItem(R.drawable.racun, "Satria", "#rock"),
            ArtistItem(R.drawable.maia, "Maia", "#pop"),
            ArtistItem(R.drawable.nadine, "Nadine", "#indie"),
            ArtistItem(R.drawable.fathia, "Fathia", "#jazz"),
            ArtistItem(R.drawable.sitha, "Sitha", "#rock"),
            ArtistItem(R.drawable.alyssa, "John", "#indie"),

        )

        val adapterArtist = ArtistAdapter(listArtist)
        rvArtist.adapter = adapterArtist

        val listWhatNew = arrayListOf<WhatNewItem>(
        WhatNewItem(R.drawable.racun, "Hindia", "Maybe I'm Amazed", "I love my wife"),
        WhatNewItem(R.drawable.racun, "Afgan ", "Maybe I'm Amazed", "I love my wife"),
        WhatNewItem(R.drawable.racun, "John Lennon", "Maybe I'm Amazed", "I love my wife"),
        WhatNewItem(R.drawable.racun, "John Lennon", "Maybe I'm Amazed", "I love my wife"),
        WhatNewItem(R.drawable.racun, "John Lennon", "Maybe I'm Amazed", "I love my wife"),
        )

        val whatNewAdapter = WhatNewAdapter(listWhatNew)
        rvWhatNew.adapter = whatNewAdapter


    }
}