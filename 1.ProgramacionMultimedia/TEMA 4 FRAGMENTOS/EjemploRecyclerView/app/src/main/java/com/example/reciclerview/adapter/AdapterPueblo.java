package com.example.reciclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ejemplorecyclerview.R;
import com.example.reciclerview.modelo.Pueblo;

import java.util.ArrayList;

public class AdapterPueblo extends RecyclerView.Adapter<AdapterPueblo.ViewHolderPueblo> {

    ArrayList<Pueblo> listaPueblos;

    public AdapterPueblo(ArrayList<Pueblo> listaPueblos) {
        this.listaPueblos = listaPueblos;
    }

    @NonNull
    @Override
    public ViewHolderPueblo onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.elemento_pueblo,null,false);
        return new ViewHolderPueblo(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPueblo holder, int position) {

    }

    @Override
    public int getItemCount() {
        return listaPueblos.size();
    }


    public class ViewHolderPueblo extends RecyclerView.ViewHolder {

        TextView urlFoto, nombre, descripcion;
        Integer numHabitantes;

        public ViewHolderPueblo(@NonNull View itemView) {
            super(itemView);
        }
    }
}
