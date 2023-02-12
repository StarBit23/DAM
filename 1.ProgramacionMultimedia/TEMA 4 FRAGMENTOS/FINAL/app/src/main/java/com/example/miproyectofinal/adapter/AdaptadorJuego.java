package com.example.miproyectofinal.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.miproyectofinal.R;
import com.example.miproyectofinal.fragment.SecondFragment;
import com.example.miproyectofinal.model.Juego;


import java.util.List;

public class AdaptadorJuego extends ArrayAdapter<Juego> {

    Context context;
    List<Juego> juegosList;
    int layoutFilmElement;


    public AdaptadorJuego(@NonNull Context context, int resource, @NonNull List<Juego> objects) {
        super(context, resource, objects);
        this.context = context;
        juegosList = objects;
        layoutFilmElement = resource;
    }

    /**
     * @param filmList
     * @param secondFragment
     */
    public AdaptadorJuego(List<Juego> filmList, SecondFragment secondFragment) {
        super(secondFragment.getContext(), R.layout.elemento_juego, filmList);
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View PilotoViewElement = LayoutInflater.
                from(parent.getContext()).
                inflate(layoutFilmElement, parent, false);


        Juego pilotoActual = juegosList.get(position);
        JuegoView pilotoView = new JuegoView(PilotoViewElement);
        setFilmView(pilotoActual, pilotoView);
        return PilotoViewElement;
    }




    private void setFilmView(Juego juegoActual, JuegoView filmView) {
        filmView.nombreJuego.setText(juegoActual.getNombre().toString());
        filmView.descripcionJuego.setText(juegoActual.getDescripcion().toString());
        filmView.descripcionJuego.setText(juegoActual.getNumVentas().toString());
    }





    public class JuegoView {
        private View view;
        private Juego juegos;

        public final TextView nombreJuego;
        public final TextView descripcionJuego;
        public final TextView ventasJuego;
        public final ImageView imagenJuego;
        public final ImageView imgEditar;
        public final ImageView imgBorrar;


        public JuegoView(View viewElement){
            view = viewElement;
            nombreJuego = view.findViewById(R.id.textViewNombre);
            descripcionJuego = view.findViewById((R.id.textViewDescripcion));
            ventasJuego = view.findViewById(R.id.textViewVentas);
            imagenJuego = view.findViewById(R.id.imageViewJuego);
            imgEditar = view.findViewById(R.id.imageViewEditarJuego);
            imgBorrar = view.findViewById(R.id.imageViewBorrarJuego);

        }
    }
}
