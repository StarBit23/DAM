package com.example.miapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;
    private Button button2;
    private Button button3;
    private Button button4;
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.txtButton);
        button = (Button) findViewById(R.id.button);
    }

    public void saludarAJorge(View view) {
        String saludo = "Hola Jorge";
        Toast.makeText(this, saludo, Toast.LENGTH_SHORT).show();
        txt.setText(saludo);
    }


    @Override
    public void onClick(View view) {

    }
}