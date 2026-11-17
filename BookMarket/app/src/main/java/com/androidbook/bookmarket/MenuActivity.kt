package com.androidbook.bookmarket

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MenuActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    var index = 0
    lateinit var toolbar: Toolbar
    lateinit var dLayout: DrawerLayout
    lateinit var navigation: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.setNavigationIcon(R.drawable.icon_navi)

        ViewCompat.setOnApplyWindowInsetsListener(toolbar) { v, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.statusBars())
            v.setPadding(0, bars.top, 0, 0)
            insets
        }

        navigation = findViewById(R.id.navigation)
        dLayout = findViewById(R.id.menu)

        toolbar.setNavigationOnClickListener {
            dLayout.openDrawer(Gravity.LEFT)
        }
        navigation.setNavigationItemSelectedListener(this)
    }

    fun onBookListClick(view: View?) {
        startActivity(Intent(this, BooksActivity::class.java))
    }

    fun onEBookClick(view: View?) {
        Toast.makeText(applicationContext, "E-Book 버튼을 클릭하였습니다", Toast.LENGTH_LONG).show()
    }

    fun onCustomerInquiryClick(view: View?) {
        Toast.makeText(applicationContext, "고객문의 버튼을 클릭하였습니다", Toast.LENGTH_LONG).show()
    }

    fun onMyPageClick(view: View?) {
        Toast.makeText(applicationContext, "나의페이지 버튼을 클릭하였습니다", Toast.LENGTH_LONG).show()
    }

    fun onMarketInfoClick(view: View?) {
        Toast.makeText(applicationContext, "마켓정보 버튼을 클릭하였습니다", Toast.LENGTH_LONG).show()
    }

    fun onSettingClick(view: View?) {
        Toast.makeText(applicationContext, "설정 버튼을 클릭하였습니다", Toast.LENGTH_LONG).show()
    }

    fun onBannerClick(view: View?) {
        val menuObj: ImageView = findViewById(R.id.imageView2)
        if (index % 2 == 0) menuObj.setImageResource(R.drawable.menu_banner2)
        else menuObj.setImageResource(R.drawable.menu_banner1)
        index++
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_login -> {
                val dialogView = layoutInflater.inflate(R.layout.dialog_login, null)
                val dialog = AlertDialog.Builder(this)
                    .setView(dialogView)
                    .show()

                val loginBtn: Button = dialogView.findViewById(R.id.loginBtn)
                loginBtn.setOnClickListener {
                    val tvID: TextView = dialogView.findViewById(R.id.userID)
                    val tvPW: TextView = dialogView.findViewById(R.id.userPW)
                    dialog.dismiss()
                    Toast.makeText(
                        this,
                        "아이디: " + tvID.text + " 비밀번호: " + tvPW.text,
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
            R.id.menu_myinfo -> {
                Toast.makeText(this, "메뉴2 : " + item.title, Toast.LENGTH_SHORT).show()
            }
            R.id.menu_setting -> {
                Toast.makeText(this, "메뉴3 : " + item.title, Toast.LENGTH_SHORT).show()
            }
        }

        dLayout.closeDrawers()
        return true
    }
}