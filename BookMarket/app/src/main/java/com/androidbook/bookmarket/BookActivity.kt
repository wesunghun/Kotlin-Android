package com.androidbook.bookmarket

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class BookActivity : AppCompatActivity() {

    // 도서 데이터: 이미지, 도서ID, 도서명, 정가, 출간, 지은이, 설명, 분류
    private val images = listOf(
        R.drawable.books_book1, R.drawable.books_book2,
        R.drawable.books_book3, R.drawable.books_book4
    )
    private val infos = listOf(
        listOf("BOOK1234", "쉽게 배우는 알고리즘", "32,000원", "2024-01-03", "문병로",
            "알고리즘에 대한 지식을 기반으로 제대로 된 프로그래밍을 하는 이들뿐 아니라, 알고리즘 속에 깃든 여러 가지 생각하는 방법, 자료구조, 테크닉을 통해 체계적으로 생각하는 훈련을 하고자 하는 모든 이를 대상으로 한다.",
            "IT/모바일"),
        // 아래 3권은 교재 소스의 실제 값으로 바꾸세요
        listOf("BOOK0002", "도서 2 제목", "34,000원", "2024-01-01", "지은이2", "도서 2 설명", "IT/모바일"),
        listOf("BOOK0003", "도서 3 제목", "30,000원", "2024-01-01", "지은이3", "도서 3 설명", "IT/모바일"),
        listOf("BOOK0004", "도서 4 제목", "28,000원", "2024-01-01", "지은이4", "도서 4 설명", "IT/모바일")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_book)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.book)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val index = intent.getIntExtra("index", 0).coerceIn(0, images.size - 1)

        findViewById<ImageView>(R.id.imageView1).setImageResource(images[index])

        val tvIds = listOf(
            R.id.book_tv01, R.id.book_tv02, R.id.book_tv03, R.id.book_tv04,
            R.id.book_tv05, R.id.book_tv06, R.id.book_tv07
        )
        tvIds.forEachIndexed { i, id ->
            findViewById<TextView>(id).text = infos[index][i]
        }
    }
}