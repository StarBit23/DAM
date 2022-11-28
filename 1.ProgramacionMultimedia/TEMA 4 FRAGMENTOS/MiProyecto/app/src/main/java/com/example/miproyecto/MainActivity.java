package com.example.miproyecto;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.miproyecto.adaptadores.AdaptadorPueblos;
import com.example.miproyecto.modelos.Pueblo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lista;
    private List<Pueblo> listaPueblos;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.listview_Pueblos);
        listaPueblos = new ArrayList<Pueblo>();

        listaPueblos.add(new Pueblo(null, "Socuellamos","Pueblo de Ciudad Read", 12000));
        listaPueblos.add(new Pueblo(null, "Lezuza", "Pueblo ibero-romano de Albacete", 1500));
        listaPueblos.add(new Pueblo(null, "Tomelloso", "Pueblo de Ciudad Read\n tiene buenos quesos", 20000));
        listaPueblos.add(new Pueblo(null, "Almagro","Pueblo de Ciudad Real\n joer que buenas las berenjenas", 5000));

        /*Necesitamos un Adapter que toma el contexto del Activity, el xml del diseño de cada elemento (CardView) y la lista de los Pueblos.  Ahora necesitamos un Adaptador personalizado y un diseño xml para un pueblo personalizado.*/
        ArrayAdapter<Pueblo> adapter = new AdaptadorPueblos(this, R.layout.elemento_pueblo, listaPueblos);
        lista.setAdapter(adapter);

        /*Ahora gestionaremos los eventos click, sobre cada elemento de la lista*/
        lista.setOnItemClickListener(
                (adaptador, vista, posicion, l)->{
                    Toast.makeText(MainActivity.this, "Pueblo seleccioinado " +  listaPueblos.get(posicion), Toast.LENGTH_SHORT).show();
                }
        );
    }
}