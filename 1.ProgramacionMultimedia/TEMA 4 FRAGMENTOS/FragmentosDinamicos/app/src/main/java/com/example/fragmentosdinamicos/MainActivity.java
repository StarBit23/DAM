package com.example.fragmentosdinamicos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements CambiarColor{
    View fragmentoInferior;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragmentSuperior , new FragmentoArriba())
                .add(R.id.fragmentInferior , new FragmentoPrincipal())
                .commit();

        fragmentoInferior = findViewById(R.id.fragmentInferior);
    }

    @Override
    public void cambiarColor(int color) {
        fragmentoInferior.setBackgroundColor(color);
    }
}