package com.example.ejemplo1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button btn1;
Button btn2;
Button btn3;
TextView editFocus;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        editFocus = findViewById(R.id.editTextFocus);
        View viewMain = new View(this);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verValor(viewMain);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cerrarTeclado(viewMain);
            }

        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ;
                asignarFocus(viewMain);
            }
        });
    }

    public void verValor(View viewMain){
        EditText txtTelefono = findViewById(R.id.editTextPhone);
        Log.d("Valor ET",txtTelefono.getText().toString());
    }

    private void asignarFocus(View viewMain) {
        editFocus.setFocusable(true);

        if (editFocus.isFocusable()){
            editFocus.requestFocus();
            Toast.makeText(this, "Foco asignado", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "No se puede asignar el focus", Toast.LENGTH_SHORT).show();
        }
    }

    private void cerrarTeclado(View viewMain) {

    }
}