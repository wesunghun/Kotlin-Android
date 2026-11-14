package com.androidbook.example

import android.util.Log

class Person {
    var name: String
    var age: Int

    init {
        println("기본 생성자 초기화")
    }

    constructor(pname: String, page: Int){
        this.name = pname
        this.age = page


        Log.d("코틀린 : 객체 지향 프로그래밍 ", "Person 이름: $name")
        Log.d("코틀린 : 객체 지향 프로그래밍 ", "Person 나이: $age")
    }
}