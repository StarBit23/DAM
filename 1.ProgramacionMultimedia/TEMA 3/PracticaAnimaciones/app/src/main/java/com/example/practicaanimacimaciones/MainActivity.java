package com.example.practicaanimacimaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private ImageView txtHola;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtHola = findViewById(R.id.txt1);
        //Creo la animación
        Animation miAnimacion = AnimationUtils.loadAnimation(this, R.anim.translacion);
        //Configuro la animación
        miAnimacion.setRepeatMode(Animation.RESTART);
        miAnimacion.setRepeatCount(20);
        //Aplicamos la animación (fin)
        txtHola.startAnimation(miAnimacion);




    }
}