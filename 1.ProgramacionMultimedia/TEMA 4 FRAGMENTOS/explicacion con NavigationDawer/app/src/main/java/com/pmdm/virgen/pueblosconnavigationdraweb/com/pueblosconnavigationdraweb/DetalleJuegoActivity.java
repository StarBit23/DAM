package com.pmdm.virgen.pueblosconnavigationdraweb.com.pueblosconnavigationdraweb;

import android.os.Bundle;

import com.pmdm.virgen.pueblosconnavigationdraweb.com.pueblosconnavigationdraweb.modelos.Juego;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.pueblosconnavigationdraweb.R;
import com.pueblosconnavigationdraweb.databinding.ActivityScrollingBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

//import com.appJuegosFinal.databinding.ActivityScrollingBinding;

import io.realm.Realm;


public class DetalleJuegoActivity extends AppCompatActivity {

    private ActivityScrollingBinding binding;
    TextView textNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        textNombre = findViewById(R.id.textViewNombre);

        binding = ActivityScrollingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());

        FloatingActionButton fab = binding.fab;

        Bundle bundle = this.getIntent().getExtras();
        long idJuego = bundle.getLong(Juego.ARGUMENTO_ID);
        //realm = Realm.getDefaultInstance();
        Juego juego = Realm.getDefaultInstance() //realm
                .where(Juego.class)
                .equalTo(Juego.ARGUMENTO_ID, idJuego)
                .findFirst();

        textNombre.setText(juego.getNombre().toString());

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}