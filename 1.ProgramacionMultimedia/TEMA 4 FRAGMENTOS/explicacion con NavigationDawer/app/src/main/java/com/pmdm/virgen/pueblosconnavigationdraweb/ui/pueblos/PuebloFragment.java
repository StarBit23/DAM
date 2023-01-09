package com.pmdm.virgen.pueblosconnavigationdraweb.ui.pueblos;

import android.app.Activity;
import android.content.Context;
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
import com.pmdm.virgen.pueblosconnavigationdraweb.MainActivity;
import com.pmdm.virgen.pueblosconnavigationdraweb.R;
import com.pmdm.virgen.pueblosconnavigationdraweb.adapter.MyPuebloRecyclerViewAdapter;
import com.pmdm.virgen.pueblosconnavigationdraweb.dialogos.DialogoConfirmacion;
import com.pmdm.virgen.pueblosconnavigationdraweb.dialogos.EditarPuebloDialogo;
import com.pmdm.virgen.pueblosconnavigationdraweb.dialogos.NuevoPueblo;
import com.pmdm.virgen.pueblosconnavigationdraweb.listener.OnPuebloInteractionDialogListener;
import com.pmdm.virgen.pueblosconnavigationdraweb.listener.OnPuebloInteractionListener;
import com.pmdm.virgen.pueblosconnavigationdraweb.modelos.Pueblo;
import com.pmdm.virgen.pueblosconnavigationdraweb.varios.Contador;

import java.util.ArrayList;
import java.util.List;


public class PuebloFragment extends Fragment implements OnPuebloInteractionListener, OnPuebloInteractionDialogListener {
    private static final String TAG = "MiActivity";
    private List<Pueblo> listaPueblos;
    private Context contexto;
    private FloatingActionButton bFlotanteInsertar;


  //  private OnPuebloInteractionListener listener;
    private MyPuebloRecyclerViewAdapter miAdaptador;


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public PuebloFragment(){
        crearObjetosDinamicos();

    }

    public PuebloFragment(List<Pueblo> lista) {

        listaPueblos = lista;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
       listaPueblos = new ArrayList<Pueblo>();

        listaPueblos.add(new Pueblo(null, "Socuellamos","Pueblo de Ciudad Read", 12000));
        listaPueblos.add(new Pueblo(null, "Lezuza", "Pueblo ibero-romano de Albacete", 1500));
        listaPueblos.add(new Pueblo(null, "Tomelloso", "Pueblo de Ciudad Read, tiene buenos quesos", 20000));
        listaPueblos.add(new Pueblo(null, "Almagro","Pueblo de Ciudad Real, joer que buenas las berenjenas", 5000));

        */

    }



    public void crearObjetosDinamicos(){
        listaPueblos = new ArrayList<Pueblo>();

        listaPueblos.add(new Pueblo(0,null, "Socuellamos","Pueblo de Ciudad Read", 12000));
        listaPueblos.add(new Pueblo(1,null, "Lezuza", "Pueblo ibero-romano de Albacete", 1500));
        listaPueblos.add(new Pueblo(2,null, "Tomelloso", "Pueblo de Ciudad Read, tiene buenos quesos", 20000));
        listaPueblos.add(new Pueblo(3,null, "Almagro","Pueblo de Ciudad Real, joer que buenas las berenjenas", 5000));
        for (int i=0; i<4; i++ )
            Contador.increId();
    }


    /*
    Comprobamos si el Activity implementa de la interfaz.
     */
   /*
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnPuebloInteractionListener)
            listener = (OnPuebloInteractionListener) context;
        else
            throw new IllegalArgumentException("Debe implementar el Listener OnPuebloInteractionListener");

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
        View view = inflater.inflate(R.layout.fragment_pueblo_root2, container, false);

        bFlotanteInsertar = view.findViewById(R.id.btn_flo_insertar);
        bFlotanteInsertar.setOnClickListener(
                (evento)->{
                    NuevoPueblo dNuevo = new NuevoPueblo(this);
                    MainActivity acti = (MainActivity)contexto;
                    dNuevo.show(acti.getSupportFragmentManager(), "Insertar Nuevo Pueblo");
                }
        );

        // Set the adapter
  //      if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = view.findViewById(R.id.lista_pueblos);
         //   RecyclerView recyclerView = (RecyclerView) view;
            miAdaptador = new MyPuebloRecyclerViewAdapter(listaPueblos, this);
            recyclerView.setAdapter(miAdaptador);
   //     }
        return view;
    }

    public void actualizaAdaptador(){
        miAdaptador.notifyDataSetChanged();
    }

    @Override
    public void onPuebloClick(Pueblo pueblo) {

    }



    @Override
    public void onPuebloEditarClick(Pueblo pueblo) {
        Toast.makeText(contexto, "Edición: " + pueblo.toString(), Toast.LENGTH_SHORT).show();
        Log.i(TAG, "Edicion: " + pueblo.toString());
        EditarPuebloDialogo dialogoEditar =  EditarPuebloDialogo.newInstance(this,
                pueblo.getId(),
                pueblo.getNombre(),
                pueblo.getDescripcion(),
                pueblo.getNumHabitantes(),
                pueblo.getUrlFoto());
        MainActivity acti = (MainActivity)contexto;
        dialogoEditar.show(acti.getSupportFragmentManager(), "Edición datos del Pueblo "+pueblo.getNombre());

    }

    @Override


    public void onPuebloBorrarClick(Pueblo pueblo) {
        //Toast.makeText(this, "Borrado: "+pueblo.toString(), Toast.LENGTH_SHORT).show();
        Log.i(TAG, "Borrado: "+ pueblo.toString());
        MainActivity acti = (MainActivity)contexto;
        DialogoConfirmacion.newInstance(acti, this, pueblo.getId());



    }

    @Override
    public void insertarPueblo(String nombre, String descripcion, int nHabitantes) {
        Contador.increId();
        listaPueblos.add(new Pueblo( Contador.dameId(),null,nombre, descripcion, nHabitantes));
    }

    @Override
    public void editarPueblo(long id, String nombre, String descripcion, int nHabitantes) {
        int i=0;
        Pueblo aux=null;
        int tam = listaPueblos.size();
        while (aux==null && i<tam){
            if (listaPueblos.get(i).getId()==id)
                aux = listaPueblos.get(i);
            i++;
        }
        if (aux!=null){
            aux.setNombre(nombre);
            aux.setDescripcion(descripcion);
            aux.setNumHabitantes(nHabitantes);
            aux.setUrlFoto(null);  //ya modificaremos esto cuando toque.
            Toast.makeText (contexto, "Se ha actualizado correctamente", Toast.LENGTH_SHORT).show();
            //debo notificar el cambio desde el fragmento.
            actualizaAdaptador();
        }else
            Toast.makeText (contexto, "Se ha producido algun error", Toast.LENGTH_SHORT).show();



    }

    @Override
    public void eliminarPueblo(long id) {
        int i=0;
        boolean encontrado = false;
        int tam = listaPueblos.size();
        while (!encontrado && i<tam){
            if (listaPueblos.get(i).getId()==id) {
                listaPueblos.remove(i);
                encontrado = true;
            }
            i++;
        }
        if (encontrado){
            Toast.makeText (contexto, "Se ha eliminado correctamente", Toast.LENGTH_SHORT).show();
            //debo notificar el cambio desde el fragmento.
            actualizaAdaptador();
        }else
            Toast.makeText (contexto, "Se ha producido algun error", Toast.LENGTH_SHORT).show();

    }
}