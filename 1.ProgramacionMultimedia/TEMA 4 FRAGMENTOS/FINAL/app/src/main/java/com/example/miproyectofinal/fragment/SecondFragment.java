package com.example.miproyectofinal.fragment;

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

        listaJuegos.add(new Juego("https://cdn-2.motorsport.com/images/mgl/24vA3r46/s8/max-verstappen-red-bull-racing-1.jpg", "Max Verstappen","Edad: 25", "Red Bull",1));
        listaJuegos.add(new Juego("https://cdn-8.motorsport.com/images/mgl/0a9neZP0/s8/sergio-perez-red-bull-racing-1.jpg", "Sergio Perez","Edad: 32", "RedBull",2));
        listaJuegos.add(new Juego("https://cdn-7.motorsport.com/images/mgl/0mb95oa2/s8/lewis-hamilton-mercedes-1.jpg", "Lewis Hamilton","Edad: 32", "Mercedes",3));
        listaJuegos.add(new Juego("https://cdn-7.motorsport.com/images/mgl/6l9yjoj0/s8/george-russell-mercedes-1.jpg", "George Russel","Edad: 24", "Mercedes",4));
        listaJuegos.add(new Juego("https://cdn-7.motorsport.com/images/mgl/63vAdQEY/s800/valtteri-bottas-alfa-romeo-1.jpg", "Valtteri Bottas","Edad: 33", "Alfa Romeo",5));
        listaJuegos.add(new Juego("https://cdn-4.motorsport.com/images/mgl/YMdn9Xl2/s800/guanyu-zhou-alfa-romeo-1.jpg", "Guanyu Zhou","Edad: 23", "Alfa Romeo",6));
        listaJuegos.add(new Juego("https://cdn-1.motorsport.com/images/amp/01W1vqDY/s1000/formula-1-2022-fernando-alonso-2.jpg", "Fernando Alonso","Edad: 41", "Aston Martin",7));
        listaJuegos.add(new Juego("https://cdn-7.motorsport.com/images/mgl/0RrnLBB0/s800/lance-stroll-aston-martin-1.jpg", "Lance Stroll","Edad: 24", "Aston Martin",8));
        listaJuegos.add(new Juego("https://cdn-2.motorsport.com/images/mgl/6VRnqmN6/s8/charles-leclerc-ferrari-1.jpg", "Charles Leclerc","Edad: 25", "Ferrari",9));
        listaJuegos.add(new Juego("https://cdn-2.motorsport.com/images/mgl/YXRnk570/s8/carlos-sainz-jr-ferrari-1.jpg", "Carlos Sainz","Edad: 28", "Ferrari",10));
        listaJuegos.add(new Juego("https://cdn-2.motorsport.com/images/mgl/6zQ7ev7Y/s8/esteban-ocon-alpine-1.jpg", "Esteban Ocon","Edad: 26", "Alpine", 11));
        listaJuegos.add(new Juego("https://cdn-1.motorsport.com/images/amp/2QzL5EvY/s1000/formula-1-news-2022-pierre-gas-2.jpg", "Pierre Gasly","Edad: 26", "Alpine", 12));
        listaJuegos.add(new Juego("https://cdn-3.motorsport.com/images/mgl/0L1nLWJ2/s800/lando-norris-mclaren-1.jpg", "Lando Norris ","Edad: 23", "McLaren", 13));
        listaJuegos.add(new Juego("https://storage.googleapis.com/wtf1-com.appspot.com/1/Piastri-2022-McLaren-Mock-Up.jpg", "Oscar Piastri","Edad: 21", "McLaren", 14));
        listaJuegos.add(new Juego("https://cdn-8.motorsport.com/images/mgl/24vOGKX6/s800/kevin-magnussen-haas-f1-team-1.jpg", "Kevin Magnussen","Edad: 30", "Haas" ,15));
        listaJuegos.add(new Juego("https://cdn-1.motorsport.com/images/amp/68yP3k90/s6/nico-hulkenberg-aston-martin-1.jpg", "Nico Hulkenberg","Edad: 35", "Haas", 16));
        listaJuegos.add(new Juego("https://cdn-5.motorsport.com/images/mgl/24vA3zN6/s800/yuki-tsunoda-alphatauri-1.jpg", "Yuki Tsunoda","Edad: 22", "Alpha Tauri", 17));
        listaJuegos.add(new Juego("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/nyck-de-vries-of-netherlands-mercedes-test-and-reserve-news-photo-1667580543.jpg", "Nyck de Vries","Edad: 27", "Alpha Tauri", 18));
        listaJuegos.add(new Juego("https://cdn-1.motorsport.com/images/amp/2jXdJPk6/s6/alex-albon-williams-1.jpg", "Alexander Albon","Edad: 26", "Williams", 19));
        listaJuegos.add(new Juego("https://cdn-1.motorsport.com/images/amp/6zQp8VjY/s1000/logan-sargeant-williams-academ.jpg", "Logan Sargeant","Edad: 21", "Williams",20));

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

    public void actualizaAdaptador(){
        adaptador.notifyDataSetChanged();
    }
}