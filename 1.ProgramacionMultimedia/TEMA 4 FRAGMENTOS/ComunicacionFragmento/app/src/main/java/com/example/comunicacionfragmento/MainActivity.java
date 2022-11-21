package com.example.comunicacionfragmento;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragmentContainerView, new BlankFragment())
                .commit();
    }

    @Override
    public void mostrarTextoOnClick(String texto) {
        Toast.makeText(this, texto, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void operacionSuma(int entero1, int entero2) {
        String resultado = String.valueOf(entero1+entero2);
        Toast.makeText(this, "la suma vale "+resultado, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void operacionResta(int entero1, int entero2) {
        String resultado = String.valueOf(entero1+entero2);
        Toast.makeText(this, "la resta vale "+resultado, Toast.LENGTH_SHORT).show();
    }
}