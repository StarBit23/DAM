package com.example.tarea11;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    private Button exitBtn2;
    private Button btnContador2;
    int contador2=0;
    TextView resultado;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        exitBtn2= findViewById(R.id.btn_volver2);
        resultado= findViewById(R.id.txt_normal2);
        btnContador2= findViewById(R.id.btn_click2);

        exitBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(contador2);
                finish();
            }
        });

        btnContador2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador2++;
                resultado.setText("Has pulsado "+contador2+" veces");
            }
        });
    }
}