package com.example.ejemplointent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DatosActivity extends AppCompatActivity {

    private Button botonVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        String nombre = getIntent().getStringExtra("nombre");
        int numero = getIntent().getIntExtra("numero",0);
        Toast.makeText(this, "mi nombre es "+nombre +" y mi numero es "+ numero, Toast.LENGTH_SHORT).show();

        botonVolver = (Button) findViewById(R.id.btn_datos1);
        View.OnClickListener eventBotonVolver = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Intent intentVolver = new Intent();
            }
        };
    }
}