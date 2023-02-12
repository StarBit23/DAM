package com.example.miproyecto;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.miproyecto.modelo.Juego;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class ItemFragmentJuego extends Fragment {

    private List<Juego> listaJuego;
    private Context contexto;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        contexto = context;
    }

    public ItemFragmentJuego() {
        listaJuego = new ArrayList<Juego>();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listaJuego.add(new Juego("https://i.3djuegos.com/juegos/5327/super_mario_bros/fotos/ficha/super_mario_bros-1698422.jpg", "Super Mario Bros","Plataforma: NES", "40,24 millones"));
        listaJuego.add(new Juego("https://imagen.nextn.es/wp-content/uploads/2016/05/1605-02-Super-Mario-64.jpg?strip=all&lossy=1&ssl=1", "Super Mario 64","Plataforma: Nintendo 64", "11,91 millones"));
        listaJuego.add(new Juego("https://static.wikia.nocookie.net/nintendo/images/4/46/Super-mario-sunshine.jpg/revision/latest?cb=20190610184927&path-prefix=es", "Super Mario Sunshine", "Plataforma: Gamecube", "6,28 millones"));
        listaJuego.add(new Juego("https://i.blogs.es/e789c0/smg/1366_2000.jpg", "Super Mario Galaxy","Plataforma: Wii", "12,79 millones."));
        listaJuego.add(new Juego("https://www.nintenderos.com/wp-content/uploads/2010/03/art-box-super-mario-galaxy-2.jpg", "Super Mario Galaxy 2","Plataforma: Wii", "7,41 millones"));
        listaJuego.add(new Juego("https://mario.wiki.gallery/images/7/7e/MP8Box.png", "Mario Party 8","Plataforma: Nintendo Wii", "8,85 millones"));
        listaJuego.add(new Juego("https://assets-prd.ignimgs.com/2022/01/08/super-mario-3d-land-button-1641601333288.jpg", "Super Mario 3D Land","Plataforma: Nintendo 3DS", "12,50 millones"));
        listaJuego.add(new Juego("https://uvejuegos.com/img/caratulas/53586/Mario-maker.jpg", "Super Mario Maker","Plataforma: Wii U", "4 millones"));
        listaJuego.add(new Juego("https://art.gametdb.com/wiiu/coverHQ/US/ARPE01.jpg", "New Super Mario Bros U","Plataforma: Wii U", "5,80 millones"));
        listaJuego.add(new Juego("https://i.3djuegos.com/juegos/14356/mario_kart_8_switch/fotos/ficha/mario_kart_8_switch-3611054.webp", "Mario Kart 8 Deluxe", "Plataforma: Switch", "49 millones"));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_juego, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;

            recyclerView.setAdapter(new MyItemRecyclerViewAdapter(listaJuego, contexto));
        }
        return view;
    }
}