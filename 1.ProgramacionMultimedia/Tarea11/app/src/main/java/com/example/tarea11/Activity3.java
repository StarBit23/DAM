package com.example.tarea11;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity3 extends AppCompatActivity {

    private Button btnContador3;
    private Button btnVolverMain3;
    TextView resultado;
    int contador3=0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        resultado=(TextView) findViewById(R.id.txt_act3);
        btnContador3=(Button) findViewById(R.id.btn_click3);
        btnVolverMain3=(Button) findViewById(R.id.btn_volvermain3);
        btnVolverMain3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(contador3);
                finish();
            }
        });

        btnContador3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador3 = contador3+10;
                resultado.setText("Contador: "+contador3+"");
            }
        });


    }
}