package com.example.tarea12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnAct2;
    private TextView txtNombre;
    private String nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAct2=findViewById(R.id.btn_ir_act2);
        txtNombre=findViewById(R.id.txt_main);

        nombre = txtNombre.getText().toString();
        Bundle parametros = new Bundle();
        parametros.putString("sNombre", nombre);

        btnAct2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Activity2.class);
                i.putExtras(parametros);
                startActivity(i);
            }
        });
    }
}