package com.pmdm.virgen.pueblosconnavigationdraweb.ui.pueblos;

import static com.pmdm.virgen.pueblosconnavigationdraweb.ApiService.retrofit;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pmdm.virgen.pueblosconnavigationdraweb.ApiService;
import com.pmdm.virgen.pueblosconnavigationdraweb.MainActivity;
import com.pmdm.virgen.pueblosconnavigationdraweb.R;
import com.pmdm.virgen.pueblosconnavigationdraweb.adapter.MyPuebloRecyclerViewAdapter;
import com.pmdm.virgen.pueblosconnavigationdraweb.dialogos.DialogoConfirmacion;
import com.pmdm.virgen.pueblosconnavigationdraweb.dialogos.EditarJuegoDialogo;
import com.pmdm.virgen.pueblosconnavigationdraweb.dialogos.NuevoPueblo;
import com.pmdm.virgen.pueblosconnavigationdraweb.listener.OnJuegoInteractionDialogListener;
import com.pmdm.virgen.pueblosconnavigationdraweb.listener.OnJuegoInteractionListener;
import com.pmdm.virgen.pueblosconnavigationdraweb.modelos.Juego;
import com.pmdm.virgen.pueblosconnavigationdraweb.responses.ResponseListadoJuegos;
import com.pmdm.virgen.pueblosconnavigationdraweb.varios.Contador;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class JuegoFragment extends Fragment implements OnJuegoInteractionListener, OnJuegoInteractionDialogListener {
    private static final String TAG = "MiActivity";
    private List<Juego> listaJuegos;
    private Context contexto;
    private FloatingActionButton bFlotanteInsertar;

    private SharedPreferences sharedPreferences;
    public String token;



  //  private OnJuegoInteractionListener listener;
    private MyPuebloRecyclerViewAdapter miAdaptador;


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public JuegoFragment(){
        listaJuegos = new ArrayList<Juego>();
        //crearObjetosDinamicos();
    }

    public JuegoFragment(List<Juego> lista) {

        listaJuegos = lista;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Bundle bundle = getArguments();
        //token = bundle.getString("claveString");



        /*
       listaJuegos = new ArrayList<Juego>();

        listaJuegos.add(new Juego(null, "Socuellamos","Juego de Ciudad Read", 12000));
        listaJuegos.add(new Juego(null, "Lezuza", "Juego ibero-romano de Albacete", 1500));
        listaJuegos.add(new Juego(null, "Tomelloso", "Juego de Ciudad Read, tiene buenos quesos", 20000));
        listaJuegos.add(new Juego(null, "Almagro","Juego de Ciudad Real, joer que buenas las berenjenas", 5000));

        */

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        contexto = getContext();
        SharedPreferences preferences = getActivity().getSharedPreferences("preferencias", contexto.MODE_PRIVATE);
        token = preferences.getString("preferenciaToken",null);

        Toast.makeText(getActivity(), token, Toast.LENGTH_SHORT).show();
        listarJuegosApi();
    }

    public void crearObjetosDinamicos(){





//        listaJuegos.add(new Juego(0,null, "Super Mario Bros","Plataforma: NES", "40,24 millones"));
//        listaJuegos.add(new Juego(1,null, "Super Mario 64", "Plataforma: Nintendo 64", "11,91 millones"));
//        listaJuegos.add(new Juego(2,null, "Super Mario Sunshine", "Plataforma: Gamecube", "6,28 millones"));
//        listaJuegos.add(new Juego(3,null, "Super Mario Galaxy","Plataforma: Wii", "12,79 millones"));
//        listaJuegos.add(new Juego(4,null, "Super Mario Galaxy 2","Plataforma: Wii", "12,79 millones"));
//        listaJuegos.add(new Juego(5,null, "Mario Party 8","Plataforma: Wii", "8,85 millones"));
//        listaJuegos.add(new Juego(6,null, "Super Mario 3D Land","Plataforma: Nintendo 3DS", "12,50 millones"));
//        listaJuegos.add(new Juego(7,null, "Super Mario Maker","Plataforma: Wii U", "4 millones"));
//        listaJuegos.add(new Juego(8,null, "New Super Mario Bros U","Plataforma: Wii U", "5,80 millones"));
//        listaJuegos.add(new Juego(9,null, "Mario Kart 8 Deluxe","Plataforma: Switch", "49 millones"));

        for (int i=0; i<10; i++ )
            Contador.increId();
    }

    private void listarJuegosApi(){
        ApiService apiService = retrofit.create(ApiService.class);
        Call<ResponseListadoJuegos> call = apiService.getListJuego(token);
        System.out.println("REQUEST: "+call.request());
        call.enqueue(new Callback<ResponseListadoJuegos>() {
            @Override
            public void onResponse(Call<ResponseListadoJuegos> call, Response<ResponseListadoJuegos> response) {
                listaJuegos = response.body().getPueblos();
                System.out.println("LISTA: " + listaJuegos);
            }

            @Override
            public void onFailure(Call<ResponseListadoJuegos> call, Throwable t) {
                System.out.println("ERROR LISTADO USUSARIOS");
                System.out.println(t.getCause());
                System.out.println(t.getStackTrace());
                System.out.println(t.getLocalizedMessage());
            }
        });

    }


    /*
    Comprobamos si el Activity implementa de la interfaz.
     */
   /*
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnJuegoInteractionListener)
            listener = (OnJuegoInteractionListener) context;
        else
            throw new IllegalArgumentException("Debe implementar el Listener OnJuegoInteractionListener");

    }

    */



    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        contexto = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_juego_root2, container, false);

        bFlotanteInsertar = view.findViewById(R.id.btn_flo_insertar);
        bFlotanteInsertar.setOnClickListener(
                (evento)->{
                    NuevoPueblo dNuevo = new NuevoPueblo(this);
                    MainActivity acti = (MainActivity)contexto;
                    dNuevo.show(acti.getSupportFragmentManager(), "Insertar Nuevo Juego");
                }
        );

        // Set the adapter
  //      if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = view.findViewById(R.id.lista_pueblos);
         //   RecyclerView recyclerView = (RecyclerView) view;
            miAdaptador = new MyPuebloRecyclerViewAdapter(listaJuegos, this);
            recyclerView.setAdapter(miAdaptador);
   //     }
        return view;
    }

    public void actualizaAdaptador(){
        miAdaptador.notifyDataSetChanged();
    }

    @Override
    public void onJuegoClick(Juego juego) {

    }



    @Override
    public void onJuegoEditarClick(Juego juego) {
        Toast.makeText(contexto, "Edición: " + juego.toString(), Toast.LENGTH_SHORT).show();
        Log.i(TAG, "Edicion: " + juego.toString());
        EditarJuegoDialogo dialogoEditar =  EditarJuegoDialogo.newInstance(this,
                juego.getId(),
                juego.getNombre(),
                juego.getDescripcion(),
                juego.getVentas(),
                juego.getImagen());
        MainActivity acti = (MainActivity)contexto;
        dialogoEditar.show(acti.getSupportFragmentManager(), "Edición datos del Juego "+ juego.getNombre());

    }

    @Override


    public void onJuegoBorrarClick(Juego juego) {
        //Toast.makeText(this, "Borrado: "+juego.toString(), Toast.LENGTH_SHORT).show();
        Log.i(TAG, "Borrado: "+ juego.toString());
        MainActivity acti = (MainActivity)contexto;
        DialogoConfirmacion.newInstance(acti, this, juego.getId());



    }


    public void insertarJuego(int id_usuario,String nombre, String descripcion, String nVentas) {

    }

    @Override
    public void insertarJuego(String nombre, String descripcion, String nVentas) {

    }

    @Override
    public void editarJuego(long id, String nombre, String descripcion, String nVentas) {
//        int i=0;
//        Juego aux=null;
//        int tam = listaJuegos.size();
//        while (aux==null && i<tam){
//            if (listaJuegos.get(i).getId()==id)
//                aux = listaJuegos.get(i);
//            i++;
//        }
//        if (aux!=null){
//            aux.setNombre(nombre);
//            aux.setDescripcion(descripcion);
//            aux.setVentas(nVentas);
//            aux.setImagen(null);  //ya modificaremos esto cuando toque.
//            Toast.makeText (contexto, "Se ha actualizado correctamente", Toast.LENGTH_SHORT).show();
//            //debo notificar el cambio desde el fragmento.
//            actualizaAdaptador();
//        }else
//            Toast.makeText (contexto, "Se ha producido algun error", Toast.LENGTH_SHORT).show();
//
//

    }

    @Override
    public void eliminarJuego(String id) {
//        int i=0;
//        boolean encontrado = false;
//        int tam = listaJuegos.size();
//        while (!encontrado && i<tam){
//            if (listaJuegos.get(i).getId()==id) {
//                listaJuegos.remove(i);
//                encontrado = true;
//            }
//            i++;
//        }
//        if (encontrado){
//            Toast.makeText (contexto, "Se ha eliminado correctamente", Toast.LENGTH_SHORT).show();
//            //debo notificar el cambio desde el fragmento.
//            actualizaAdaptador();
//        }else
//            Toast.makeText (contexto, "Se ha producido algun error", Toast.LENGTH_SHORT).show();

    }


}