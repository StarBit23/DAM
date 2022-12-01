package com.example.miproyecto.adaptadores;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.miproyecto.R;
import com.example.miproyecto.modelo.Juego;
import java.util.List;


public class AdaptadorJuegos extends ArrayAdapter<Juego> {

    Context contexto;
    List<Juego> listaJuegos;
    int layoutElementoJuego;

    public AdaptadorJuegos(@NonNull Context context, int resource, @NonNull List<Juego> objects) {
        super(context, resource, objects);
        contexto = context;
        listaJuegos = objects;
        layoutElementoJuego = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View vistaElementoJuego = LayoutInflater.from(parent.getContext()).inflate(layoutElementoJuego, parent, false);

        Juego juegoActual = listaJuegos.get(position); //obtenemos el pueblo actual, dada la posición a pintar.
        ViewJuego vistaJuego = new ViewJuego(vistaElementoJuego);  //creamos nuestro objeto que contiene las referencias de cada elemento de la IU
        seteaJuegoEnVista(juegoActual, vistaJuego);//seteamos en los elementos de la vista, los datos del objeto pueblo.

        return vistaElementoJuego;  //devolvemos la vista creada con los datos seteados en sus campos.
    }


    private void seteaJuegoEnVista(Juego juegoActual, ViewJuego vistaJuego) {
        vistaJuego.textViewNombre.setText(juegoActual.getNombre().toString());
        vistaJuego.textViewDescripcion.setText(juegoActual.getDescripcion().toString());
        vistaJuego.textViewVentas.setText(juegoActual.getNumVentas());
    }


    public class ViewJuego {
        private View vista;
        private Juego juego;

        public final TextView textViewNombre;
        public final TextView textViewDescripcion;
        public final TextView textViewVentas;
        public final ImageView imageViewJuego;
        public final ImageView imageViewVentas;
        public final ImageView imageViewEditarJuego;
        public final ImageView imageViewBorrarJuego;


        public ViewJuego(View vistaElemento){
            vista = vistaElemento;
            textViewNombre = vista.findViewById(R.id.textViewNombre);
            textViewDescripcion = vista.findViewById((R.id.textViewDescripcion));
            textViewVentas = vista.findViewById(R.id.textViewVentas);
            imageViewJuego = vista.findViewById(R.id.imageViewJuego);
            imageViewVentas = vista.findViewById(R.id.imageViewVentas);
            imageViewEditarJuego = vista.findViewById(R.id.imageViewEditarJuego);
            imageViewBorrarJuego = vista.findViewById(R.id.imageViewBorrarJuego);

        }
    }

}