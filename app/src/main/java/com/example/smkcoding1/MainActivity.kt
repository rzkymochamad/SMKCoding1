package com.example.smkcoding1

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setDataSpinnerGender()

        btnSave.setOnClickListener { goToProfilActivity() }
    }

    private fun setDataSpinnerGender() {
        val adapter = ArrayAdapter.createFromResource(this, R.array.jenis_kelamin, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        txt_jk.adapter = adapter
    }

    private fun goToProfilActivity() {
        val intent = Intent(this, ProfilActivity::class.java)
        intent.putExtra("nama", txt_nama.text.toString())
        intent.putExtra("jk", txt_jk.selectedItem.toString())
        intent.putExtra("umur", txt_umur.text.toString())
        intent.putExtra("email", txt_email.text.toString())
        intent.putExtra("telp", txt_telp.text.toString())
        intent.putExtra("alamat", txt_alamat.text.toString())

        startActivity(intent)
    }
}