package com.example.intentcontador;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    private Button exitBtn;
    private Button btnContador;
    int contador;
    TextView resultado;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        exitBtn=(Button) findViewById(R.id.button_exit);
        resultado=(TextView) findViewById(R.id.txt_click2);

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               /* Intent i = new Intent(Activity2.this,MainActivity.class);
                startActivity(i);
                */
               setResult(contador);
               finish();


            }
        });

        btnContador=(Button) findViewById(R.id.btn_contador);
        btnContador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 contador++;
                 resultado.setText("Has pulsado "+contador+" veces");
                //Toast.makeText(Activity2.this, "pulsado", Toast.LENGTH_SHORT).show();
            }
        });

    }
}