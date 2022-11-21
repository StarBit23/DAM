package com.example.comunicacionfragmento;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.GnssAntennaInfo;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {

private OnFragmentInteractionListener listener;

private TextView editNombre;
private Button botonAceptar;
private TextView editEntero1;
private TextView editEntero2;
private Button botonSumar;
private Button botonRestar;

    public BlankFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof  OnFragmentInteractionListener){
            listener = (OnFragmentInteractionListener) context;
        }else {
            throw new RuntimeException(context.toString() + " no has implementado la interfaz");
        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_blank, container, false);
        editNombre = vista.findViewById(R.id.editTextTextPersonName);
        botonAceptar = vista.findViewById(R.id.button);

        botonAceptar.setOnClickListener(v -> {
            listener.mostrarTextoOnClick(String.valueOf(editNombre.getText()));
        });

        editEntero1 = vista.findViewById(R.id.editTextNumber1);
        editEntero1 = vista.findViewById(R.id.editTextNumber2);
        botonSumar = vista.findViewById(R.id.buttonSumar);
        botonSumar.setOnClickListener(v -> {
            int entero1 = Integer.parseInt(editEntero1.getText().toString());
            int entero2 = Integer.parseInt(editEntero2.getText().toString());
            listener.operacionSuma(entero1,entero2);
        });

        botonRestar = vista.findViewById(R.id.buttonRestar);
        botonRestar.setOnClickListener(v -> {
            int entero1 = Integer.parseInt(editEntero1.getText().toString());
            int entero2 = Integer.parseInt(editEntero2.getText().toString());
            listener.operacionResta(entero1,entero2);
        });
        return vista;
    }
}