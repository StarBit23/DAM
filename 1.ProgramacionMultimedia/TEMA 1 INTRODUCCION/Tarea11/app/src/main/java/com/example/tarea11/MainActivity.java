package com.example.tarea11;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnAct2;
    private Button btnAct3;
    final int COD_ACTI2 = 10;
    final int COD_ACTI3 = 20;
    TextView resultado;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultado = findViewById(R.id.txt_normal_1);
        btnAct2 = findViewById(R.id.btn_ir_act2);
        btnAct3 = findViewById(R.id.btn_act3);
        btnAct2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Activity2.class);
                startActivityForResult(i, COD_ACTI2);
            }
        });

        btnAct3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Activity3.class);
                startActivityForResult(i, COD_ACTI3);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == COD_ACTI2) {
            resultado.setText("Contador: " + resultCode + " en Activity2");
        }
        if (requestCode == COD_ACTI3) {
            resultado.setText("Contador " + resultCode + " en Activity3");
        }
    }
}