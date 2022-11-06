package com.example.proyectodados;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtResultado;
    ImageView imgDado1;
    ImageView imgDado2;
    ImageView imgDado3;
    ImageView imgCubilete;
    private int suma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View viewMain = new View(this);
        txtResultado = findViewById(R.id.txt_resultado);
        txtResultado.setVisibility(View.INVISIBLE);
        imgDado1 = (ImageView)findViewById(R.id.img_dado1);
        imgDado2 = (ImageView)findViewById(R.id.img_dado2);
        imgDado3 = (ImageView)findViewById(R.id.img_dado3);
        imgCubilete = findViewById(R.id.img_vaso);
        imgCubilete.setOnClickListener(v -> tirarDados(viewMain));

    }

    @SuppressLint("SuspiciousIndentation")
    public void tirarDados(View v){
        int milisegundos = 1000;
        int i;

        txtResultado.setVisibility(View.INVISIBLE);
        for (i=1; i<5; i++)
            programarCuandoTirar(milisegundos*i, v);
            programarCuandoMostrarResultados(milisegundos*i++);
        
    }



    public void programarCuandoTirar(int milisegundos, View v){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    mostrarDatos();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, milisegundos);
    }

    private void mostrarDatos() throws InterruptedException {
        int valor1 = 1+(int)(Math.random()*6);
        int valor2 = 1+(int)(Math.random()*6);
        int valor3 = 1+(int)(Math.random()*6);
        switch (valor1){
            case 1:
                imgDado1.setImageResource(R.drawable.dado1);break;
            case 2:
                imgDado1.setImageResource(R.drawable.dado2);break;
            case 3:
                imgDado1.setImageResource(R.drawable.dado3);break;
            case 4:
                imgDado1.setImageResource(R.drawable.dado4);break;
            case 5:
                imgDado1.setImageResource(R.drawable.dado5);break;
            case 6:
                imgDado1.setImageResource(R.drawable.dado6);break;
        }

        switch (valor2){
            case 1:
                imgDado2.setImageResource(R.drawable.dado1);break;
            case 2:
                imgDado2.setImageResource(R.drawable.dado2);break;
            case 3:
                imgDado2.setImageResource(R.drawable.dado3);break;
            case 4:
                imgDado2.setImageResource(R.drawable.dado4);break;
            case 5:
                imgDado2.setImageResource(R.drawable.dado5);break;
            case 6:
                imgDado2.setImageResource(R.drawable.dado6);break;
        }

        switch (valor3){
            case 1:
                imgDado3.setImageResource(R.drawable.dado1);break;
            case 2:
                imgDado3.setImageResource(R.drawable.dado2);break;
            case 3:
                imgDado3.setImageResource(R.drawable.dado3);break;
            case 4:
                imgDado3.setImageResource(R.drawable.dado4);break;
            case 5:
                imgDado3.setImageResource(R.drawable.dado5);break;
            case 6:
                imgDado3.setImageResource(R.drawable.dado6);break;
        }

        suma=valor1+valor2+valor3;
    }

    private void programarCuandoMostrarResultados(int milisegundos){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mostrarResultado();
            }
        }, milisegundos);
    }

    private void mostrarResultado() {
        txtResultado.setVisibility(View.VISIBLE);
        txtResultado.setText(String.valueOf(suma));
    }


}