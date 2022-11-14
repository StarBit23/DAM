package com.example.proyectodados;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtResultado;
    EditText txtAdivinar;
    String adivinar;
    TextView txtGanaste;
    ImageView imgDado1;
    ImageView imgDado2;
    ImageView imgDado3;
    ImageView imgCubilete;
    int valor1;
    int valor2;
    int valor3;
    private int suma;
    Animation rotate;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View viewMain = new View(this);
        txtGanaste = findViewById(R.id.txtGanaste);
        txtAdivinar = findViewById(R.id.txtAdivinar);
        txtResultado = findViewById(R.id.txt_resultado);
        imgDado1 = (ImageView)findViewById(R.id.img_dado1);
        imgDado2 = (ImageView)findViewById(R.id.img_dado2);
        imgDado3 = (ImageView)findViewById(R.id.img_dado3);
        imgCubilete = findViewById(R.id.img_vaso);
        imgCubilete.setOnClickListener(v -> tirarDados(viewMain));
        rotate = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotation);
    }

    @SuppressLint("SuspiciousIndentation")
    public void tirarDados(View v){
        imgCubilete.setEnabled(false);
        int milisegundos = 1000;
        int i;

        txtGanaste.setVisibility(View.INVISIBLE);
        txtResultado.setVisibility(View.INVISIBLE);
        for (i=1; i<4; i++)
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
        //Random
        valor1 = 1+(int)(Math.random()*6);
        valor2 = 1+(int)(Math.random()*6);
        valor3 = 1+(int)(Math.random()*6);
        suma=valor1+valor2+valor3;
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
        imgDado1.startAnimation(rotate);
        imgDado2.startAnimation(rotate);
        imgDado3.startAnimation(rotate);
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
        txtResultado.setText(String.valueOf(suma));
        txtResultado.setVisibility(View.VISIBLE);
        adivinar = txtAdivinar.getText().toString();
        if (Integer.parseInt(adivinar)==suma){
            txtGanaste.setVisibility(View.VISIBLE);
        }
        imgCubilete.setEnabled(true);
    }


}