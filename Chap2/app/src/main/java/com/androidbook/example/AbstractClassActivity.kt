package com.androidbook.example

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

abstract class AbstractClassActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val myDog = Dog3()

        Log.d("코틀린 : 객체 지향 프로그래밍 ", "Dog 클래스: ${myDog.sound()}")
    }
}

abstract class Animal3 {
    abstract fun sound() : String
}

class Dog3 : Animal3() {
    override fun sound() : String {
        return "멍멍"
    }
}