package com.example.tarea12;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    private TextView txtNombre;
    private String nombre;
    private Button btnVolverMain;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        txtNombre=findViewById(R.id.txt_act2);
        btnVolverMain=findViewById(R.id.btn_ir_act_main);
        Bundle parametros = this.getIntent().getExtras();
        nombre = parametros.getString("sNombre");
        txtNombre.setText(nombre);

        btnVolverMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Activity2.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}