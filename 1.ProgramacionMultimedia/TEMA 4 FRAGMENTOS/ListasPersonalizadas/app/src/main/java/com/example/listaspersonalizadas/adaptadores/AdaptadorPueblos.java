package com.example.listaspersonalizadas.adaptadores;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.listaspersonalizadas.R;
import com.example.listaspersonalizadas.modelos.Pueblo;
import com.example.listaspersonalizadas.placeholder.PlaceholderContent.PlaceholderItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class AdaptadorPueblos extends ArrayAdapter<Pueblo> {

    Context contexto;
    List<Pueblo> listaPueblos;
    int layoutElementoPueblo;

    public AdaptadorPueblos(@NonNull Context context, int resource, @NonNull List<Pueblo> objects) {
        super(context, resource, objects);
        contexto = context;
        listaPueblos = objects;
        layoutElementoPueblo = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View vistaElementoPueblo = LayoutInflater.
                from(parent.getContext()).
                inflate(layoutElementoPueblo, parent, false);

        /*
        Una vez que tenga la vista, ahora tengo que rescatar los elementos de la interfaz de usuasrio del elemento_pueblo.xml
         */

        Pueblo puebloActual = listaPueblos.get(position); //obtenemos el pueblo actual, dada la posición a pintar.
        ViewPueblo vistaPueblo = new ViewPueblo(vistaElementoPueblo);  //creamos nuestro objeto que contiene las referencias de cada elemento de la IU
        seteaPuebloEnVista(puebloActual, vistaPueblo);//seteamos en los elementos de la vista, los datos del objeto pueblo.
        return vistaElementoPueblo;  //devolvemos la vista creada con los datos seteados en sus campos.
    }

    /*
    Método que setea cada atributo del objeto pueblo seleccionado
    en su correspondiente objeto java que está vinculado a su elemento de la IU.
     */
    private void seteaPuebloEnVista(Pueblo puebloActual, ViewPueblo vistaPueblo) {
        vistaPueblo.textViewNombre.setText(puebloActual.getNombre().toString());
        vistaPueblo.textViewDescripcion.setText(puebloActual.getDescripcion().toString());
        vistaPueblo.textViewHabitantes.setText(String.valueOf(puebloActual.getNumHabitantes()));
    }

    /*
    Esta clase, se encarga de relacionar cada elemento de la vista con los objetos java.
     */
    public class ViewPueblo{
        private View vista;
        private Pueblo pueblo;

        public final TextView textViewNombre;
        public final TextView textViewDescripcion;
        public final TextView textViewHabitantes;
        public final ImageView imageViewPueblo;
        public final ImageView imageViewEditarPueblo;
        public final ImageView imageViewBorrarPueblo;


        public ViewPueblo(View vistaElemento){
            vista = vistaElemento;
            textViewNombre = vista.findViewById(R.id.textViewNombre);
            textViewDescripcion = vista.findViewById((R.id.textViewDescripcion));
            textViewHabitantes = vista.findViewById(R.id.textViewHabitantes);
            imageViewPueblo = vista.findViewById(R.id.imageViewPueblo);
            imageViewEditarPueblo = vista.findViewById(R.id.imageViewEditarPueblo);
            imageViewBorrarPueblo = vista.findViewById(R.id.imageViewBorrarPueblo);

        }
    }
}