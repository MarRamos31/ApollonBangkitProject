package com.example.apollon

import android.content.Intent
import android.content.res.AssetFileDescriptor
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import org.tensorflow.lite.Interpreter
import java.io.FileInputStream
import java.nio.MappedByteBuffer
import java.nio.channels.FileChannel

class BottomNavigation : AppCompatActivity() {


    lateinit var keShop: ImageView
    lateinit var keChat: ImageView


    val resultArray = Array(1) { ByteArray(3) }

    val interpreter by lazy {
        loadModelFile()?.let { Interpreter(it) }
    }


    private fun loadModelFile(): MappedByteBuffer? {
        val fileDescriptor: AssetFileDescriptor = assets.openFd("model.tflite")
        val inputStream = FileInputStream(fileDescriptor.fileDescriptor)
        val fileChannel: FileChannel = inputStream.channel
        val startOffset: Long = fileDescriptor.startOffset
        val declaredLength: Long = fileDescriptor.declaredLength
        return fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)


        keShop = findViewById(R.id.ke_shop)
        keChat = findViewById(R.id.ke_chat)

        keShop.setOnClickListener{
            val pindhKeShop = Intent(this@BottomNavigation, ShopActivity::class.java)
            startActivity(pindhKeShop)
        }

        keChat.setOnClickListener{
            val pindahkeChat = Intent(this@BottomNavigation, ChatActivity::class.java)
            startActivity(pindahkeChat)
        }



        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
//        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}