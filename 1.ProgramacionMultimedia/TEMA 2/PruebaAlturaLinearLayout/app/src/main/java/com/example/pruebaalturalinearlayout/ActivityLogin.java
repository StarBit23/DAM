package com.example.pruebaalturalinearlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class ActivityLogin extends AppCompatActivity {
private ImageView imagenUsuario;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        imagenUsuario=findViewById(R.id.imgUsuario);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha);
        animation.setRepeatMode(Animation.RESTART);
        imagenUsuario.startAnimation(animation);

    }
}