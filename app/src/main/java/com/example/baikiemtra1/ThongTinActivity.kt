package com.example.baikiemtra1

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ThongTinActivity : AppCompatActivity() {
    lateinit var tv_ten: TextView
    lateinit var tv_msv: TextView
    lateinit var tv_lop: TextView
    lateinit var tv_trangthai: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thongtin)
        tv_ten = findViewById(R.id.tv_ten)
        tv_msv = findViewById(R.id.tv_msv)
        tv_lop = findViewById(R.id.tv_lop)
        tv_trangthai = findViewById(R.id.tv_trangthai)
        val hoTen = intent.getStringExtra("hoTen")
        tv_ten.text = hoTen
    }
}