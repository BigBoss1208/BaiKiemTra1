package com.example.baikiemtra1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.isDigitsOnly
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {

    lateinit var ed_hoten: EditText
    lateinit var ed_email: EditText
    lateinit var ed_sdt: EditText
    lateinit var ed_nganh: EditText
    lateinit var rb_nam: RadioButton
    lateinit var rb_nu: RadioButton
    lateinit var rg_gt: RadioGroup
    lateinit var bt_gui: Button
    lateinit var tv_tb: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        ed_hoten = findViewById(R.id.ed_hoten)
        ed_email = findViewById(R.id.ed_email)
        ed_sdt = findViewById(R.id.ed_sdt)
        ed_nganh = findViewById(R.id.ed_nganh)

        rb_nam = findViewById(R.id.rb_nam)
        rb_nu = findViewById(R.id.rb_nu)
        rg_gt = findViewById(R.id.rg_gt)

        bt_gui = findViewById(R.id.bt_gui)
        tv_tb = findViewById(R.id.tv_tb)


        // Câu 3:
        // Kiểm tra số điện thoại khi người dùng nhập

        ed_sdt.addTextChangedListener {

            if (ed_sdt.text.toString().isDigitsOnly()) {
                tv_tb.text = ""
            } else {
                tv_tb.text = "Số điện thoại phải là số"
            }

        }


        // Nút Gửi thông tin

        bt_gui.setOnClickListener {

            // Lấy dữ liệu người dùng nhập

            val hoTen = ed_hoten.text.toString()
            val email = ed_email.text.toString()
            val soDienThoai = ed_sdt.text.toString()
            val nganhHoc = ed_nganh.text.toString()

            var gioiTinh = ""

            if (rb_nam.isChecked) {
                gioiTinh = "Nam"
            }

            if (rb_nu.isChecked) {
                gioiTinh = "Nữ"
            }


            // Kiểm tra họ tên

            if (hoTen == "") {
                ed_hoten.error = "Không được bỏ trống"
                return@setOnClickListener
            }


            // Kiểm tra email

            if (email == "") {
                ed_email.error = "Không được bỏ trống"
                return@setOnClickListener
            }


            // Kiểm tra số điện thoại

            if (soDienThoai == "") {
                ed_sdt.error = "Không được bỏ trống"
                return@setOnClickListener
            }


            // Kiểm tra ngành học

            if (nganhHoc == "") {
                ed_nganh.error = "Không được bỏ trống"
                return@setOnClickListener
            }


            // Kiểm tra giới tính

            if (gioiTinh == "") {
                tv_tb.text = "Vui lòng chọn giới tính"
                return@setOnClickListener
            }


            // Kiểm tra số điện thoại có phải số không

            if (!soDienThoai.isDigitsOnly()) {
                tv_tb.text = "Số điện thoại phải là số"
                return@setOnClickListener
            }

            // Lưu thông tin và chuyển sang giao diện 2

            val intent = Intent(this, ThongTinActivity::class.java)

            intent.putExtra("hoTen", hoTen)
            intent.putExtra("email", email)
            intent.putExtra("soDienThoai", soDienThoai)
            intent.putExtra("nganhHoc", nganhHoc)
            intent.putExtra("gioiTinh", gioiTinh)

            startActivity(intent)
        }
    }
}