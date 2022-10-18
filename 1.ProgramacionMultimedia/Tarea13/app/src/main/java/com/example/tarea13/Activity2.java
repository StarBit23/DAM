package com.example.tarea13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    private Button btnIrMain;
    private TextView txt2;
    private  String nombreBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        btnIrMain=findViewById(R.id.btn_act2_main);
        txt2=findViewById(R.id.txt_act2);

        Bundle parametros = this.getIntent().getExtras();
        nombreBundle = parametros.getString("sNombre");
        txt2.setText(nombreBundle);

        btnIrMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Activity2.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}