package com.example.pruebaalturalinearlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class ActivityLogin extends AppCompatActivity {
<<<<<<< HEAD
private ImageView imagenLogin;
=======
private ImageView imagenUsuario;
>>>>>>> 238310560361a0eacc4f8f00f0b3fb0fe8da0894
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
<<<<<<< HEAD
        imagenLogin = findViewById(R.id.imagenLogin);

        Animation animacionRotacion = AnimationUtils.loadAnimation(this, R.anim.animacion1);
        animacionRotacion.setRepeatMode(Animation.RESTART);
        animacionRotacion.setRepeatCount(20);
        imagenLogin.startAnimation(animacionRotacion);
=======
        imagenUsuario=findViewById(R.id.imgUsuario);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha);
        animation.setRepeatMode(Animation.RESTART);
        imagenUsuario.startAnimation(animation);

>>>>>>> 238310560361a0eacc4f8f00f0b3fb0fe8da0894
    }
}