package com.example.smkcoding1

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setDataSpinnerGender()

        btnSave.setOnClickListener { validasiInput() }
    }

    private fun setDataSpinnerGender() {
        val adapter = ArrayAdapter.createFromResource(this, R.array.jenis_kelamin, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        txt_jk.adapter = adapter
    }

    private fun validasiInput(){
        when{
            txt_nama.text.toString().isEmpty() -> txt_nama.error = "Nama Tidak Boleh Kosong"
            txt_jk.selectedItem.toString().equals("Pilih Jenis Kelamin", ignoreCase = true) -> tampilToast("Jenis Kelamin harus dipilih!")
            txt_umur.text.toString().isEmpty() -> txt_umur.error = "Umur Tidak Boleh Kosong"
            txt_email.text.toString().isEmpty() -> txt_email.error = "Email Tidak Boleh Kosong"
            txt_telp.text.toString().isEmpty() -> txt_telp.error = "No Telp Tidak Boleh Kosong"
            txt_alamat.text.toString().isEmpty() -> txt_alamat.error = "Alamat Tidak Boleh Kosong"

            else -> {
                tampilToast("Berhasil")
                goToProfilActivity()
            }
        }
    }

    private fun tampilToast(pesan: String) {
        Toast.makeText(this, pesan, Toast.LENGTH_SHORT).show()
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