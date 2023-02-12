package com.example.miproyectofinal.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.miproyectofinal.MainActivity;
import com.example.miproyectofinal.R;
import com.example.miproyectofinal.adapter.MyItemRecyclerViewAdapter;
import com.example.miproyectofinal.databinding.FragmentSecondBinding;
import com.example.miproyectofinal.dialog.Dialogo;
import com.example.miproyectofinal.dialog.DialogoConfirmacion;
import com.example.miproyectofinal.dialog.EditarJuegoDialogo;
import com.example.miproyectofinal.listener.OnJuegoDialogInteractionListener;
import com.example.miproyectofinal.listener.OnJuegoInteractionListener;
import com.example.miproyectofinal.model.Contador;
import com.example.miproyectofinal.model.Juego;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class SecondFragment extends Fragment implements OnJuegoDialogInteractionListener, OnJuegoInteractionListener {

    private static final String TAG = "SecondFragment";
    private FragmentSecondBinding binding;
    private List<Juego> listaJuegos;
    private FloatingActionButton botonFlotante;
    private Context contexto;
    private MyItemRecyclerViewAdapter adaptador;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        crearObjetosDinamicos();

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        contexto = context;
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        View view = inflater.inflate(R.layout.fragment_second_root, container, false);

        Context context = view.getContext();
        RecyclerView recyclerView = view.findViewById(R.id.lista_elementos_juego);
        adaptador = new MyItemRecyclerViewAdapter(listaJuegos, this);
        recyclerView.setAdapter(adaptador);

        return view;

        /*binding = FragmentSecondBinding.inflate(inflater, container, false);


        //filmFragment = new FilmFragment(filmList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        adapter = new FilmAdapter(filmList,this);

        getParentFragmentManager().
         beginTransaction().
         add(R.layout.fragment_film,filmFragment,"film").
         commit();*/

         /*fab = findViewBy(R.id.fab);
        fab.setOnClickListener(event ->{
        NewFilm newFilm = new NewFilm();
        newFilm.show(getParentFragmentManager(),"Insertar Nueva Película");
        });**/

        //return binding.getRoot();

    }

    public void crearObjetosDinamicos(){

        listaJuegos = new ArrayList<>();

        listaJuegos.add(new Juego("https://i.3djuegos.com/juegos/5327/super_mario_bros/fotos/ficha/super_mario_bros-1698422.jpg", "Super Mario Bros","Plataforma: NES", "40,24 millones",1));
        listaJuegos.add(new Juego("https://imagen.nextn.es/wp-content/uploads/2016/05/1605-02-Super-Mario-64.jpg?strip=all&lossy=1&ssl=1", "Super Mario 64","Plataforma: Nintendo 64", "11,91 millones",2));
        listaJuegos.add(new Juego("https://static.wikia.nocookie.net/nintendo/images/4/46/Super-mario-sunshine.jpg/revision/latest?cb=20190610184927&path-prefix=es", "Super Mario Sunshine", "Plataforma: Gamecube", "6,28 millones",3));
        listaJuegos.add(new Juego("https://i.blogs.es/e789c0/smg/1366_2000.jpg", "Super Mario Galaxy","Plataforma: Wii", "12,79 millones.",4));
        listaJuegos.add(new Juego("https://www.nintenderos.com/wp-content/uploads/2010/03/art-box-super-mario-galaxy-2.jpg", "Super Mario Galaxy 2","Plataforma: Wii", "7,41 millones",5));
        listaJuegos.add(new Juego("https://mario.wiki.gallery/images/7/7e/MP8Box.png", "Mario Party 8","Plataforma: Nintendo Wii", "8,85 millones",6));
        listaJuegos.add(new Juego("https://assets-prd.ignimgs.com/2022/01/08/super-mario-3d-land-button-1641601333288.jpg", "Super Mario 3D Land","Plataforma: Nintendo 3DS", "12,50 millones",7));
        listaJuegos.add(new Juego("https://uvejuegos.com/img/caratulas/53586/Mario-maker.jpg", "Super Mario Maker","Plataforma: Wii U", "4 millones",8));
        listaJuegos.add(new Juego("https://art.gametdb.com/wiiu/coverHQ/US/ARPE01.jpg", "New Super Mario Bros U","Plataforma: Wii U", "5,80 millones",9));
        listaJuegos.add(new Juego("https://i.3djuegos.com/juegos/14356/mario_kart_8_switch/fotos/ficha/mario_kart_8_switch-3611054.webp", "Mario Kart 8 Deluxe", "Plataforma: Switch", "49 millones",10));

        for(int i=0;i<6;i++){
            Contador.incrementarId();
        }

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /*binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });*/

        botonFlotante = view.findViewById(R.id.floatingActionButton);
        botonFlotante.setOnClickListener(
                (event)-> {
                    Dialogo nuevoJuego = new Dialogo(this);
                    MainActivity activity = (MainActivity) contexto;
                    nuevoJuego.show(activity.getSupportFragmentManager(), "Insertar nuevo piloto");
                }
        );

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onPuebloClick(Juego juego) {

    }

    public void onJuegoEditarClick(Juego juego) {
        EditarJuegoDialogo dialogoEditar =  EditarJuegoDialogo.newInstance(this,
                juego.getId(),
                juego.getNombre(),
                juego.getDescripcion(),
                juego.getNumVentas(),
                juego.getUrlFoto());
        MainActivity activity = (MainActivity) contexto;
        dialogoEditar.show(activity.getSupportFragmentManager(), "Edición datos del Pueblo "+juego.getNombre());
    }

    @Override
    public void onJuegoBorrarClick(Juego juego) {
        MainActivity activity = (MainActivity) contexto;
        DialogoConfirmacion.newInstance(activity,this, juego.getId());
    }


    @Override
    public void insertarJuego(String nombre, String descripcion, String ventas) {
        Contador.incrementarId();
        listaJuegos.add(new Juego(Contador.dameId(),null, nombre, descripcion, ventas));
    }

    @Override
    public void editarJuego(long id, String nombre, String descripcion, String ventas) {
        int i=0;
        Juego aux=null;
        int tam = listaJuegos.size();
        while (aux==null && i<tam){
            if (listaJuegos.get(i).getId()==id)
                aux = listaJuegos.get(i);
            i++;
        }
        if (aux!=null){
            aux.setNombre(nombre);
            aux.setDescripcion(descripcion);
            aux.setNumVentas(ventas);
            aux.setUrlFoto(null);  //ya modificaremos esto cuando toque.
            Toast.makeText (getActivity(), "Se ha actualizado correctamente", Toast.LENGTH_SHORT).show();
            //debo notificar el cambio desde el fragmento.
            actualizaAdaptador();
        }else
            Toast.makeText (getActivity(), "Se ha producido algun error", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void borrarJuego(long id) {
        int i=0;
        boolean encontrado = false;
        int tam = listaJuegos.size();
        while (!encontrado && i<tam){
            if (listaJuegos.get(i).getId()==id) {
                listaJuegos.remove(i);
                encontrado = true;
            }
            i++;
        }
        if (encontrado){
            Toast.makeText (getActivity(), "Se ha eliminado correctamente", Toast.LENGTH_SHORT).show();
            //debo notificar el cambio desde el fragmento.
            actualizaAdaptador();
        }else
            Toast.makeText (getActivity(), "Se ha producido algun error", Toast.LENGTH_SHORT).show();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void actualizaAdaptador(){
        adaptador.notifyDataSetChanged();
    }
}