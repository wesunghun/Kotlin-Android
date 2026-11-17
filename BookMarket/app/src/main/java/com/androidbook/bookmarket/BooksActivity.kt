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

    // 도서 데이터: 도서ID, 도서명, 정가, 출간, 지은이, 설명, 분류
    // 2~4번 도서는 교재 소스의 실제 값으로 바꾸세요
    private val bookData = listOf(
        arrayOf(
            "BOOK1234", "쉽게 배우는 알고리즘", "32,000원", "2024-01-03", "문병로",
            "알고리즘에 대한 지식을 기반으로 제대로 된 프로그래밍을 하는 이들뿐 아니라, 알고리즘 속에 깃든 여러 가지 생각하는 방법, 자료구조, 테크닉을 통해 체계적으로 생각하는 훈련을 하고자 하는 모든 이를 대상으로 한다.",
            "IT/모바일"
        ),
        arrayOf("BOOK1235", "도서 2 제목", "34,000원", "2024-01-01", "지은이2", "도서 2 설명", "IT/모바일"),
        arrayOf("BOOK1236", "도서 3 제목", "30,000원", "2024-01-01", "지은이3", "도서 3 설명", "IT/모바일"),
        arrayOf("BOOK1237", "도서 4 제목", "28,000원", "2024-01-01", "지은이4", "도서 4 설명", "IT/모바일")
    )

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
        val d = bookData[index]
        val intent = Intent(this, BookActivity::class.java)
        intent.putExtra("bookid", d[0])
        intent.putExtra("name", d[1])
        intent.putExtra("price", d[2])
        intent.putExtra("date", d[3])
        intent.putExtra("writer", d[4])
        intent.putExtra("description", d[5])
        intent.putExtra("category", d[6])
        startActivity(intent)
    }
}