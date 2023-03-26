package com.pmdm.virgen.pueblosconnavigationdraweb.adapter;

import static com.pmdm.virgen.pueblosconnavigationdraweb.ApiService.retrofit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.pmdm.virgen.pueblosconnavigationdraweb.ApiService;
import com.pmdm.virgen.pueblosconnavigationdraweb.R;
import com.pmdm.virgen.pueblosconnavigationdraweb.RegisterActivity;
import com.pmdm.virgen.pueblosconnavigationdraweb.Usuario;
import com.pmdm.virgen.pueblosconnavigationdraweb.listener.OnJuegoInteractionListener;
import com.pmdm.virgen.pueblosconnavigationdraweb.modelos.Juego;
import com.pmdm.virgen.pueblosconnavigationdraweb.responses.ResponseListadoJuegos;
import com.pmdm.virgen.pueblosconnavigationdraweb.responses.ResponseRegister;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyPuebloRecyclerViewAdapter extends RecyclerView.Adapter<MyPuebloRecyclerViewAdapter.ViewPueblo> {

    private final List<Juego> mValues;
    private OnJuegoInteractionListener listenerPueblo;

    public MyPuebloRecyclerViewAdapter(List<Juego> items, OnJuegoInteractionListener listener) {
        mValues = items;
        listenerPueblo = listener;
    }

    @Override
    public ViewPueblo onCreateViewHolder(ViewGroup parent, int viewType) {
        View vistaElementoPueblo = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.elemento_pueblo, parent, false);

        return new ViewPueblo(vistaElementoPueblo);

    }

    @Override
    public void onBindViewHolder(final ViewPueblo holder, int position) {

        //posible edicion pasando lista de la api (desde JuegoFragmen)
        holder.mItem = mValues.get(position);
        holder.textViewNombre.setText(holder.mItem.getNombre());
        holder.textViewDescripcion.setText(holder.mItem.getDescripcion());
        holder.textViewVentas.setText(String.valueOf(holder.mItem.getVentas()));

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    /*
    Esta clase, es la encargada de recibir la vista inflada del elemento gráfico, asociarle
    elementos de la vista con objetos java para poder setear datos en sus campos.
     */
    public class ViewPueblo extends RecyclerView.ViewHolder {
        public final TextView textViewNombre;
        public final TextView textViewDescripcion;
        public final TextView textViewVentas;
        public final ImageView imageViewPueblo;
        public final ImageView imageViewEditarPueblo;
        public final ImageView imageViewBorrarPueblo;
        public Juego mItem;  //es el objeto pueblo que representa el objeto
        public View vista;  //será el constrain layout del layout_pueblos_item



        public ViewPueblo(View view) {
            //METER LLAMADA A LA API DE LOS JUEGOS POR API-KEY (GET)



            //DATOS ANTIGUOS
            super(view.getRootView()); //le pasamos la vista a la que tiene que asociar elementos.
            vista = view;

            /**
             * Debo enlazar cada uno de los elementos de nuestro layout_pueblos_item
             * con cada propiedad de nuestra objeto interno.
             */
            textViewNombre = vista.findViewById(R.id.textViewNombre);
            textViewDescripcion = vista.findViewById(R.id.textViewDescripcion);
            textViewVentas = vista.findViewById(R.id.textViewHabitantes);
            imageViewPueblo = vista.findViewById(R.id.imageViewPueblo);
            imageViewEditarPueblo = vista.findViewById(R.id.image_view_editar_pueblo);
            imageViewBorrarPueblo = vista.findViewById(R.id.imageView_borrar_pueblo);

            imageViewEditarPueblo.setOnClickListener(
                    (evento)->{
                        listenerPueblo.onJuegoEditarClick(mItem);
                    }
            );

            imageViewBorrarPueblo.setOnClickListener(
                    (evento)->{
                        listenerPueblo.onJuegoBorrarClick(mItem);
                    }
            );


           // vista.setOnClickListener();
        }



    }
}