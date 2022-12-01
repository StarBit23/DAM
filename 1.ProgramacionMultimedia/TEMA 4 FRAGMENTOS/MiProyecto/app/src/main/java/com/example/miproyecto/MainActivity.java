package com.example.miproyecto;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import  androidx.appcompat.app.AppCompatActivity;

import com.example.miproyecto.modelo.Juego;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lista;
    private List<Juego> listaJuegos;
    private FloatingActionButton btnSalir;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSalir = findViewById(R.id.buttonSalir);
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentExit = new Intent(MainActivity.this, MainActivityLogin.class);
                Toast.makeText(MainActivity.this, "Cerrando sesión", Toast.LENGTH_SHORT).show();
                startActivity(intentExit);

            }
        });

        /*//lista = findViewById(R.id.listview_Pueblos);
        listaPueblos = new ArrayList<Pueblo>();

        listaPueblos.add(new Pueblo(null, "Socuellamos","Pueblo de Ciudad Read", 12000));
        listaPueblos.add(new Pueblo(null, "Lezuza", "Pueblo ibero-romano de Albacete", 1500));
        listaPueblos.add(new Pueblo(null, "Tomelloso", "Pueblo de Ciudad Read\n tiene buenos quesos", 20000));
        listaPueblos.add(new Pueblo(null, "Almagro","Pueblo de Ciudad Real\n joer que buenas las berenjenas", 5000));

        ArrayAdapter<Pueblo> adapter = new AdaptadorPueblos(this, R.layout.elemento_pueblo, listaPueblos);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(
                (adaptador, vista, posicion, l)->{
                    Toast.makeText(MainActivity.this, "Pueblo seleccioinado " +  listaPueblos.get(posicion), Toast.LENGTH_SHORT).show();
                }
        );*/

    }
}