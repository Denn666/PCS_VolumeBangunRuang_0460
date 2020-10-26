package com.pcs.pertemuan2pcs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class VolumeKotakKotlin : AppCompatActivity(), View.OnClickListener {
    private lateinit var txtPanjang:EditText
    private lateinit var txtLebar:EditText
    private lateinit var txtTinggi:EditText
    private lateinit var btnHasil:Button
    private lateinit var txtHasil:TextView
companion object{
    private const val STATE_RESULT = "state_result"
}
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, txtHasil.text.toString())

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)



        txtPanjang = findViewById(R.id.txtPanjang)
        txtLebar = findViewById(R.id.txtLebar)
        txtTinggi = findViewById(R.id.txtTinggi)
        btnHasil = findViewById(R.id.btnHitung)
        txtHasil = findViewById(R.id.txtHasil)

        btnHasil.setOnClickListener(this)

        if(savedInstanceState !=null){
            val hasil = savedInstanceState.getString(STATE_RESULT)
            txtHasil.text = hasil
        }
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btnHitung){
            val inputPanjang = txtPanjang.text.toString().trim()
            val inputLebar = txtLebar.text.toString().trim()
            val inputTinggi = txtTinggi.text.toString().trim()

            var isEmptyFields = false

            when{
                inputPanjang.isEmpty() -> {
                    isEmptyFields = true
                    txtPanjang.error = "Field ini tidak boleh kosong"
                }
                inputLebar.isEmpty() -> {
                    isEmptyFields = true
                    txtLebar.error = "Field ini tidak boleh kosong"
                }
                inputTinggi.isEmpty() -> {
                    isEmptyFields = true
                    txtTinggi.error = "Field ini tidak boleh kosong"
                }
            }

            if (!isEmptyFields){
                val hasil = inputPanjang.toDouble() * inputLebar.toDouble() * inputTinggi.toDouble()
                txtHasil.text = hasil.toString()
            }
        }
    }
}