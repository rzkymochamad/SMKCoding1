package com.example.smkcoding1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

//        btnBack.setOnClickListener{ goToBack()}
    }

    private fun goToBack() {
        val intent = Intent(this, ProfilActivity::class.java)
        startActivity(intent)
    }
}
