package com.example.smkcoding1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_profil.*

class ProfilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        ambilData()

        btnEdit.setOnClickListener { goToEditActivity() }
    }

    private fun ambilData() {
        txtName.setText(intent.getStringExtra("nama"))
        txtJK.setText(intent.getStringExtra("jk"))
        txtUmur.setText(intent.getStringExtra("umur"))
        txtEmail.setText(intent.getStringExtra("email"))
        txtTelp.setText(intent.getStringExtra("telp"))
        txtAlamat.setText(intent.getStringExtra("alamat"))
    }

    companion object{
        val REQUEST_CODE = 100
    }

    private  fun goToEditActivity(){
        val intent = Intent(this, EditActivity::class.java)

        val namaUser = txtName.text.toString()
        intent.putExtra("nama", namaUser)

        startActivityForResult(intent, REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == REQUEST_CODE){
            if (resultCode == Activity.RESULT_OK){
                val result = data?.getStringExtra("nama")
                txtName.text = result
            } else{
                Toast.makeText(this, "Edit Gagal", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
