package com.example.fragmentosdinamicos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private FragmentTransaction transactorFragmentos;
    private Button btnRojo, btnAmarillo;
    private FragmentoPrincipal fragPrincipal;
    private PrimerFragmento fragPrimero;
    private SegundoFragmento fragSegundo;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragPrimero = new PrimerFragmento();
        fragSegundo = new SegundoFragmento();
        fragPrincipal = new FragmentoPrincipal();

        btnRojo = findViewById(R.id.btn_rojo);
        btnAmarillo = findViewById(R.id.btn_amarillo);
        transactorFragmentos = getSupportFragmentManager().beginTransaction();

        btnRojo.setOnClickListener(v -> {
            transactorFragmentos = getSupportFragmentManager().beginTransaction();
            transactorFragmentos.replace(R.id.fragmentContainerView, fragPrimero);
            transactorFragmentos.addToBackStack(null).commit();
        });

        btnAmarillo.setOnClickListener(v -> {
            transactorFragmentos = getSupportFragmentManager().beginTransaction();
            transactorFragmentos.replace(R.id.fragmentContainerView, fragSegundo);
            transactorFragmentos.addToBackStack(null).commit();
        });
    }
}