package com.androidbook.bookmarket

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class BooksActivity : AppCompatActivity() {

    lateinit var book1Obj: ImageView
    lateinit var book2Obj: ImageView
    lateinit var book3Obj: ImageView
    lateinit var book4Obj: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_books)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.books)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        book1Obj = findViewById(R.id.book1)
        book2Obj = findViewById(R.id.book2)
        book3Obj = findViewById(R.id.book3)
        book4Obj = findViewById(R.id.book4)

        book1Obj.setOnClickListener { openBook(0) }
        book2Obj.setOnClickListener { openBook(1) }
        book3Obj.setOnClickListener { openBook(2) }
        book4Obj.setOnClickListener { openBook(3) }
    }

    private fun openBook(index: Int) {
        val intent = Intent(this, BookActivity::class.java)
        intent.putExtra("index", index)
        startActivity(intent)
    }
}