package com.androidbook.example

import android.util.Log

class Employee (empId: Int, empName: String){
    val id: Int
    val name: String

    init{
        id = empId
        name = empName

        Log.d("코틀린 : 객체 지향 프로그래밍 ", "Employee 아이디: $id")
        Log.d("코틀린 : 객체 지향 프로그래밍 ", "Employee 이름 : $name")
    }
}