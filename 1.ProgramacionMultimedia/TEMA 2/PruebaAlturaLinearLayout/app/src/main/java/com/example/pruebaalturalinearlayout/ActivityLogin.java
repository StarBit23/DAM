package com.example.pruebaalturalinearlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class ActivityLogin extends AppCompatActivity {
private ImageView imagenLogin;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        imagenLogin = findViewById(R.id.imagenLogin);

        Animation animacionRotacion = AnimationUtils.loadAnimation(this, R.anim.animacion1);
        animacionRotacion.setRepeatMode(Animation.RESTART);
        animacionRotacion.setRepeatCount(20);
        imagenLogin.startAnimation(animacionRotacion);
    }
}