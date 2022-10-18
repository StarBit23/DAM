package com.example.primeraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private final String TAG = "Activity2";
    private TextView txtSaludo;
    private Button btnActivity1;
    int i = 0;
    claseA a = new claseA(i,"estoy en el activity 2");

    @Override
    protected void onStart() {
        super.onStart();
        i=6;
        Log.d(TAG, "He empezado jom");
        a.setI(1);
    }


    @Override
    protected void onResume() {
        super.onResume();
        i=7;
        Log.d(TAG, "Estoy en resume jom");
        a.setI(2);
    }

    @Override
    protected void onPause() {
        super.onPause();
        i=8;
        Log.d(TAG, "Estoy en pausa jom");
        a.setI(3);
    }

    @Override
    protected void onStop() {
        super.onStop();
        i=9;
        Log.d(TAG, "Estoy parado jom");
        a.setI(4);
        //Toast.makeText(this, "Hasta la proxima amigo", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        i=10;
        Log.d(TAG, "Me he destruido jom");
        a.setI(5);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btnActivity1 = (Button) findViewById(R.id.btn_ir_main);
        btnActivity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(i);
            }
        });


    }
}