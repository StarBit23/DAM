package com.example.primeraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";
    int i = 0;

    private TextView txtSaludo;
    private Button btnActivity2;
    private Button btnAceptar;
    private Button btnAceptar2;
    private Button btnAceptar3;
    private Button btnAceptar4;
    claseA a = new claseA(i,"estoy en el activity main");

    public void saludarAUsuario(View view){
        String saludo = "Saludos usuario";
        Toast.makeText(this, "Hola tio bueno", Toast.LENGTH_SHORT).show();
        txtSaludo.setText(saludo);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "Me estoy creando");
        txtSaludo = findViewById(R.id.txtSaludo);
        btnAceptar = (Button) findViewById(R.id.btnAceptar);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtSaludo.setText("a");
            }
        });

        btnActivity2 = (Button) findViewById(R.id.btn_ir_activity2);
        btnActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(i);
            }
        });

        btnAceptar2 = (Button) findViewById(R.id.btn_aceptar2);
        btnAceptar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtSaludo.setText("e");
            }
        });

        btnAceptar3 = (Button) findViewById(R.id.btn_aceptar3);
        btnAceptar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtSaludo.setText("i");
            }
        });

        btnAceptar4 = (Button) findViewById(R.id.btn_aceptar4);
        btnAceptar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtSaludo.setText("o");
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        //Toast.makeText(this, "Bienvenido señor usuario", Toast.LENGTH_LONG).show();
        i=1;
        Log.d(TAG, "He empezado jom");
        a.setI(1);
        //Toast.makeText(this, a.toString() + "el pepe", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onResume() {
        super.onResume();
        i=2;
        Log.d(TAG, "Estoy en resume jom");
        a.setI(2);
    }

    @Override
    protected void onPause() {
        super.onPause();
        i=3;
        Log.d(TAG, "Estoy en pausa jom");
        a.setI(3);
    }

    @Override
    protected void onStop() {
        super.onStop();
        i=4;
        Log.d(TAG, "Estoy parado jom");
        a.setI(4);
        //Toast.makeText(this, "Hasta la proxima amigo", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        i=5;
        Log.d(TAG, "Me he destruido jom");
        a.setI(5);
    }
}