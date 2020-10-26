package com.pcs.pertemuan2pcs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class VolumeKotakJava extends AppCompatActivity implements View.OnClickListener {

    private EditText txtPanjang;
    private EditText txtLebar;
    private EditText txtTinggi;
    private Button btnHitung;
    private TextView txtHasil;
    private static final String STATE_RESULT = "state_result";

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, txtHasil.getText().toString() );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        txtPanjang = findViewById(R.id.txtPanjang);
        txtLebar = findViewById(R.id.txtLebar);
        txtTinggi = findViewById(R.id.txtTinggi);
        btnHitung = findViewById(R.id.btnHitung);
        txtHasil = findViewById(R.id.txtHasil);

        btnHitung.setOnClickListener(this);
        if(savedInstanceState !=null){
            String hasil = savedInstanceState.getString(STATE_RESULT);
            txtHasil.setText(hasil);
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnHitung){

            String inputPanjang = txtPanjang.getText().toString().trim();
            String inputLebar = txtLebar.getText().toString().trim();
            String inputTinggi = txtTinggi.getText().toString().trim();

            boolean isEmptyFields = false;

            if (TextUtils.isEmpty(inputPanjang)){
                isEmptyFields = true;
                txtPanjang.setError("Kolom ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputLebar)){
                isEmptyFields = true;
                txtLebar.setError("Kolom ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputTinggi)){
                isEmptyFields = true;
                txtTinggi.setError("Kolom ini tidak boleh kosong");
            }

            if(!isEmptyFields) {
                Double Hasil = Double.valueOf(inputPanjang) * Double.valueOf(inputLebar) * Double.valueOf(inputTinggi);
                txtHasil.setText(String.valueOf(Hasil));
            }
        }
    }
}