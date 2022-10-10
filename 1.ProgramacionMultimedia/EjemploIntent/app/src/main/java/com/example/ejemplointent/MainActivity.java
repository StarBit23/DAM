package com.example.ejemplointent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void iniciarActivity(View view) {
        /**
         * Necesitamos el contexto (this)
         * Necesitamos el activity que quiero iniciar
         * Pasaremos también parámetros al intent
         */

        Intent intentDatos = new Intent(this,DatosActivity.class);
        intentDatos.putExtra("numero",10);
        intentDatos.putExtra("nombre","Jorge");
        startActivity(intentDatos);
    }

    public void iniciarActivity2(View view) {
        Intent intentDatos = new Intent(this,DatosActivity2.class);
        startActivity(intentDatos);
    }


}