package com.example.tarea13;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int contador=0;
    private Button btnIrAct2;
    private Button btnContador;
    private TextView txt;
    private String nombreBundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIrAct2=findViewById(R.id.btn_main_act2);
        btnContador=findViewById(R.id.btn_pulsar_main);
        txt=findViewById(R.id.txt_main);

        Bundle parametros = new Bundle();

        btnIrAct2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Activity2.class);
                i.putExtras(parametros);
                startActivity(i);
            }
        });

        btnContador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador++;
                txt.setText("Has pulsado "+contador+" veces");
                nombreBundle = txt.getText().toString();
                parametros.putString("sNombre", nombreBundle);
            }
        });





    }

}