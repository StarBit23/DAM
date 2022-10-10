package com.example.primeraapp;

import androidx.appcompat.app.AppCompatActivity;

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
    private Button btnAceptar;
    private Button btnAceptar2;
    private Button btnAceptar3;
    private Button btnAceptar4;

    public void saludarAUsuario(View view){
        String saludo = "Saludos usuario";
        Toast.makeText(this, "Hola tio bueno", Toast.LENGTH_SHORT).show();
        txtSaludo.setText(saludo);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        txtSaludo = findViewById(R.id.txtSaludo);
        btnAceptar = (Button) findViewById(R.id.btnAceptar);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "Me estoy creando");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Bienvenido señor usuario", Toast.LENGTH_LONG).show();

        i=1;
        //Log.d(TAG, "He empezado jom");
        //claseA a = new claseA(2,"hola");
        //a.setI(5);
        //Toast.makeText(this, a.toString() + "el pepe", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "Estoy en resume jom");
        i=2;
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "Estoy en pausa jom");
        i=3;
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Estoy parado jom");
        i=4;
        //Toast.makeText(this, "Hasta la proxima amigo", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Me he destruido jom");
        i=5;
    }
}