package com.example.apollon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.apollon.ui.home.bundle.BundleAdapter
import com.example.apollon.ui.home.bundle.BundleItem
import com.example.apollon.ui.home.milih.MilihAdapter
import com.example.apollon.ui.home.milih.MilihItem
import com.example.apollon.ui.home.whathot.WhatHotAdapter
import com.example.apollon.ui.home.whathot.WhatHotItem

class ShopActivity : AppCompatActivity() {


    lateinit var keMain: ImageView

    private lateinit var rvMilih: RecyclerView
    private lateinit var rvBundle: RecyclerView
    private lateinit var rvWhatot: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)

        keMain = (findViewById(R.id.from_shop))

        keMain.setOnClickListener {
            val dariShop = Intent(this@ShopActivity, BottomNavigation::class.java)
            startActivity(dariShop)
        }

        rvMilih = findViewById(R.id.rv_milih)
        rvBundle = findViewById(R.id.rv_bundle)
        rvWhatot = findViewById(R.id.rv_what_hot)

        val listMilih = arrayListOf<MilihItem>(
                MilihItem(R.drawable.ahmdhani),
                MilihItem(R.drawable.alexturn),
                MilihItem(R.drawable.alyssa),
                MilihItem(R.drawable.didit),
                MilihItem(R.drawable.sitha),
        )

        val milihAdapter = MilihAdapter(listMilih)
        rvMilih.adapter = milihAdapter




        val listBundle = arrayListOf<BundleItem>(
                BundleItem(R.drawable.merchclub, "RealityShirt","80.000",R.drawable.ic_heartt, R.drawable.ic_plus),
                BundleItem(R.drawable.merchpant, "LautanTee","200.000",R.drawable.ic_heartt, R.drawable.ic_plus),
                BundleItem(R.drawable.merchrabbit, "bag rabbit","120.000",R.drawable.ic_heartt, R.drawable.ic_plus),
                BundleItem(R.drawable.rai, "Raissa's Mong","80.000",R.drawable.ic_heartt, R.drawable.ic_plus),
        )

        val bundleAdapter = BundleAdapter(listBundle)
        rvBundle.adapter = bundleAdapter


        val listHot = arrayListOf<WhatHotItem>(
                WhatHotItem(R.drawable.mocca, "Mocii","20.000",R.drawable.ic_heartt, R.drawable.ic_plus),
                WhatHotItem(R.drawable.mocci, "DRonat","20.000",R.drawable.ic_heartt, R.drawable.ic_plus),
                WhatHotItem(R.drawable.seringai, "MetalBeds","20.000",R.drawable.ic_heartt, R.drawable.ic_plus),
                WhatHotItem(R.drawable.pantorr, "Gurita Tebrbelangka","20.000",R.drawable.ic_heartt, R.drawable.ic_plus),
        )

        val hotAdapter = WhatHotAdapter(listHot)
        rvWhatot.adapter = hotAdapter


    }
}