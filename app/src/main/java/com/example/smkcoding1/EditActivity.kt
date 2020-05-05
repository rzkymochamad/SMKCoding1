package com.example.smkcoding1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        val intentData = intent.extras
        val namaUser = intentData.getString("nama")

        editNama.setText(namaUser)

        btnSaveEdit.setOnClickListener{saveData()}
    }

    private fun saveData() {
        val namaEdit = editNama.text.toString()
        if (!namaEdit.isEmpty()){
            val result = Intent()

            result.putExtra("nama", namaEdit)
            setResult(Activity.RESULT_OK, result)
        } else {
            setResult(Activity.RESULT_CANCELED)
            Toast.makeText(this, "Nama Tidak Boleh Kosong", Toast.LENGTH_SHORT).show()
        }

        finish()
    }
}
