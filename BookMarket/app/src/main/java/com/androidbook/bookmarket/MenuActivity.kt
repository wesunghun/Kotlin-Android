package com.androidbook.bookmarket

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {

    var index  =0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.menu)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun onBookListClick(view: View?) {
        val intent = Intent(this, BooksActivity::class.java)
        startActivity(intent)
    }

    fun onBannerClick(view: View?){
        val menuObj : ImageView = findViewById(R.id.banner)
        if (index %2 == 0) menuObj.setImageResource(R.drawable.menu_banner2)
        else menuObj.setImageResource(R.drawable.menu_banner1)
        index++
    }


}