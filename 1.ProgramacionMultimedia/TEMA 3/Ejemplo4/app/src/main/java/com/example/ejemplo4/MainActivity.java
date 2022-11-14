package com.example.ejemplo4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AutoCompleteTextView textViewAuto = findViewById(R.id.autocomplete_ciudad);
        TextView textCiudadElegida = findViewById(R.id.text_ciudad_elegida);
        String[] ciudades = getResources().getStringArray(R.array.arrayCiudades);

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, ciudades);

        textViewAuto.setAdapter(adapter);

        textViewAuto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String itemSeleccionado = adapterView.getItemAtPosition(1).toString();
                textCiudadElegida.setText("Ciudad elegida: "+itemSeleccionado);
                Toast.makeText(MainActivity.this, "PMDM, Has hecho click en "+itemSeleccionado, Toast.LENGTH_SHORT).show();
            }
        });
    }
}