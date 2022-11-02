package com.example.proyectodados;

import androidx.appcompat.app.AppCompatActivity;

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
    ImageView imgDado4;
    ImageView imgDado5;
    ImageView imgDado6;
    private int suma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtResultado.setVisibility(View.INVISIBLE);
        //tirarDados();
    }

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
                mostrarDatos();
            }

        }, milisegundos);
    }

    private void mostrarDatos() {
        int valor1 = 1+(int)(Math.random()*6);
        int valor2 = 1+(int)(Math.random()*6);
        int valor3 = 1+(int)(Math.random()*6);
        switch (valor1){
            case 1:
                imgDado1.setImageResource(R.drawable.dado1);break;
            case 2:
                imgDado2.setImageResource(R.drawable.dado2);break;
            case 3:
                imgDado3.setImageResource(R.drawable.dado3);break;
            case 4:
                imgDado4.setImageResource(R.drawable.dado4);break;
            case 5:
                imgDado5.setImageResource(R.drawable.dado5);break;
            case 6:
                imgDado6.setImageResource(R.drawable.dado6);break;
        }

        switch (valor2){
            case 1:
                imgDado1.setImageResource(R.drawable.dado1);break;
            case 2:
                imgDado2.setImageResource(R.drawable.dado2);break;
            case 3:
                imgDado3.setImageResource(R.drawable.dado3);break;
            case 4:
                imgDado4.setImageResource(R.drawable.dado4);break;
            case 5:
                imgDado5.setImageResource(R.drawable.dado5);break;
            case 6:
                imgDado6.setImageResource(R.drawable.dado6);break;
        }

        switch (valor3){
            case 1:
                imgDado1.setImageResource(R.drawable.dado1);break;
            case 2:
                imgDado2.setImageResource(R.drawable.dado2);break;
            case 3:
                imgDado3.setImageResource(R.drawable.dado3);break;
            case 4:
                imgDado4.setImageResource(R.drawable.dado4);break;
            case 5:
                imgDado5.setImageResource(R.drawable.dado5);break;
            case 6:
                imgDado6.setImageResource(R.drawable.dado6);break;
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


        },milisegundos);
    }

    private void mostrarResultado() {
        txtResultado.setText(String.valueOf(suma));
        txtResultado.setVisibility(View.VISIBLE);
    }


}