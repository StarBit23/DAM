package com.example.miproyecto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.miproyecto.modelo.Juego;

import java.util.List;


public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewJuego> {

    private final List<Juego> mValues;
    private Context contexto;

    public MyItemRecyclerViewAdapter(List<Juego> items, Context cont) {
        mValues = items;
        contexto = cont;
    }

    /*
    Método que devuelve un objeto ViewCurso con la vista inflada del xml elemento_curso.
    De momento está vacío. Se llenará tantas veces como elementos tenga que pintar
     */
    @Override
    public ViewJuego onCreateViewHolder(ViewGroup parent, int viewType) {
        //return new ViewHolder(FragmentItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
        View vistaElementoJuego = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.elemento_juego, parent, false);
        return new ViewJuego(vistaElementoJuego);

    }

    /*
    Inmediatamente después de que se llame al método onCreateViewHolder, se debe de setear la vista
    creada, con los datos correspondientes a los objetos del ArrayList. En el atributo position, tenemos
    la posicion para devolver el objeto Curso del ArrayList.
     */
    public void onBindViewHolder(final ViewJuego holder, int position) {
        holder.mItem = mValues.get(position);
        holder.textViewNombre.setText(holder.mItem.getNombre());
        holder.textViewDescripcion.setText(holder.mItem.getDescripcion());
        holder.textViewVentas.setText(holder.mItem.getNumVentas());

        if (holder.mItem.getUrlFoto()!= null){
            Glide.with(contexto)
                    .load(holder.mItem.getUrlFoto())
                    .into(holder.imageViewJuego);
        }
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    /*public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mIdView;
        public final TextView mContentView;
        public PlaceholderItem mItem;

        public ViewHolder(FragmentItemBinding binding) {
            super(binding.getRoot());
            mIdView = binding.itemNumber;
            mContentView = binding.content;
        }

        public ViewHolder(View view) {
            super(view.getRootView());
            mIdView = view.findViewById(R.id.item_number);
            mContentView = view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }*/

    /*
    Esta clase, es la encargada de recibir la vista inflada del elemento gráfico asociarle
    elementos de la vista de objetos
     */

    public class ViewJuego extends RecyclerView.ViewHolder {

        public final TextView textViewNombre;
        public final TextView textViewDescripcion;
        public final TextView textViewVentas;
        public final ImageView imageViewJuego;
        public final ImageView imageViewEditarJuego;
        public final ImageView imageViewBorrarJuego;
        public Juego mItem;
        public View vista;

        public ViewJuego(View vista){
            super(vista.getRootView());
            textViewNombre = vista.findViewById(R.id.textViewNombre);
            textViewDescripcion = vista.findViewById(R.id.textViewDescripcion);
            textViewVentas = vista.findViewById(R.id.textViewVentas);
            imageViewJuego = vista.findViewById(R.id.imageViewJuego);
            imageViewEditarJuego = vista.findViewById(R.id.imageViewEditarJuego);
            imageViewBorrarJuego = vista.findViewById(R.id.imageViewBorrarJuego);

        }
    }
}