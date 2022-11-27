package com.example.fragmentosdinamicos;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentoArriba#newInstance} factory method to
 * create an instance of this fragment.
 */


public class FragmentoArriba extends Fragment {
    private Button btnRojoArriba, btnAmarilloArriba;

    private CambiarColor listener;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentoArriba() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentoArriba.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentoArriba newInstance(String param1, String param2) {
        FragmentoArriba fragment = new FragmentoArriba();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof CambiarColor){
            listener = (CambiarColor) context;
        }else {
            throw new RuntimeException("Error de huevos");
        }

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_fragmento_arriba, container, false);
        btnRojoArriba = vista.findViewById(R.id.buttonArribaRojo);
        btnAmarilloArriba = vista.findViewById(R.id.buttonArribaAmarillo);

        btnRojoArriba.setOnClickListener(
                (evento) -> listener.cambiarColor(Color.parseColor("#F24824"))
        );
        btnAmarilloArriba.setOnClickListener(
                (evento) -> listener.cambiarColor(Color.parseColor("#FDEF13"))
        );
        return vista;
    }


}