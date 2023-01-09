package com.pmdm.virgen.pueblosconnavigationdraweb.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.Fragment;

import com.pmdm.virgen.pueblosconnavigationdraweb.R;
import com.pmdm.virgen.pueblosconnavigationdraweb.listener.OnPuebloInteractionDialogListener;
import com.pmdm.virgen.pueblosconnavigationdraweb.modelos.Pueblo;
import com.pmdm.virgen.pueblosconnavigationdraweb.ui.pueblos.PuebloFragment;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EditarPuebloDialogo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditarPuebloDialogo extends AppCompatDialogFragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    /**
     * Son los Argumentos que pasaremos desde el Activity.
     */
    private static final String ARGUMENTO_ID_PUEBLO = Pueblo.ARGUMENTO_ID;
    private static final String ARGUMENTO_NOMBRE_PUEBLO = Pueblo.ARGUMENTO_NOMBRE;
    private static final String ARGUMENTO_DESCRIPCION_PUEBLO = Pueblo.ARGUMENTO_DESCRIPCION;
    private static final String ARGUMENTO_N_HABITANTES = Pueblo.ARGUMENTO_NUM_HABITANTES;
    private static final String ARGUMENTO_URL_FOTO = Pueblo.ARGUMENTO_URL_FOTO;
    private Context contexto;  //contexo del Activity.

    private EditText editNombre, editDescripcion, editNHabitantes;
    private ImageView imgViewFoto;
    private OnPuebloInteractionDialogListener listener; //Referencia la interfaz de las acciones del Dialogo.
    //private long idPueblo;

    public EditarPuebloDialogo(PuebloFragment p) {
        listener = (OnPuebloInteractionDialogListener) p;
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     */
    // TODO: Rename and change types and number of parameters
    public static EditarPuebloDialogo newInstance(PuebloFragment p, long id, String nombre, String descripcion, int nHabitantes, String urlFoto ) {
        EditarPuebloDialogo dialogo = new EditarPuebloDialogo(p);
        Bundle args = new Bundle();
        // Pasamos los datos del pueblo, a los argumentos del Dialog para que sean recuperados.
        args.putLong(ARGUMENTO_ID_PUEBLO, id);  //pasamos el id del pueblo
        args.putString(ARGUMENTO_NOMBRE_PUEBLO, nombre);
        args.putString(ARGUMENTO_DESCRIPCION_PUEBLO, descripcion);
        args.putInt(ARGUMENTO_N_HABITANTES, nHabitantes);
        //args.putString(ARGUMENTO_URL_FOTO, urlFoto);

        dialogo.setArguments(args);
        return dialogo;
    }


    /**
     * Comprobamos si el Dialog implementa de la
     * interfaz. Este método es el primero que debe ejecutarse
     * después del constructor.
     */
   /*
   @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        contexto = context;
        if (contexto instanceof OnPuebloInteractionDialogListener)
            listener = (OnPuebloInteractionDialogListener) context;
        else
            throw new IllegalArgumentException("Este contexto, no implementa la interfaz OnPuebloActionListener");

    }

    */

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        //return super.onCreateDialog(savedInstanceState);
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View vista = inflater.inflate(R.layout.formulario_editar_pueblo_dialogo, null);  //inflamos la vista.
        inicializamosCampos(vista);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(vista)
                .setTitle("Datos del Pueblo")
                .setNegativeButton("Cancelar",
                        (dialogo, i) ->{
                            EditarPuebloDialogo.this.dismiss();
                        }

                        )
                .setPositiveButton("Guardar",
                        (dialogo, i) ->{
                            String nombre = editNombre.getText().toString();
                            String descripcion = editDescripcion.getText().toString();
                            int nHabitantes=0;
                            boolean error = false;
                            try{
                                nHabitantes = Integer.parseInt(editNHabitantes.getText().toString());
                            }catch (NumberFormatException e){
                                e.printStackTrace();
                                error = true;
                            }
                            if (nombre.isEmpty() || descripcion.isEmpty() || error)
                                Toast.makeText(contexto, "Los campos no pueden estar vacíos", Toast.LENGTH_SHORT).show();
                            else{
                                long id = EditarPuebloDialogo.this.getArguments().getLong(ARGUMENTO_ID_PUEBLO);
                                listener.editarPueblo(id, nombre, descripcion, nHabitantes);
                                EditarPuebloDialogo.this.dismiss();
                            }

                        });
        return builder.create();


    }

    private void inicializamosCampos(View vista) {
        editNombre = vista.findViewById(R.id.edit_nombre);
        editDescripcion = vista.findViewById(R.id.edit_descripcion);
        editNHabitantes = vista.findViewById(R.id.edit_n_habitantes);
        imgViewFoto = vista.findViewById(R.id.imageViewPueblo);

        /*
        Seteamos los campos de la vista con los argumentos recibidos desde el Activity.
         */
        editNombre.setText(this.getArguments().getString(ARGUMENTO_NOMBRE_PUEBLO));
        editDescripcion.setText(this.getArguments().getString(ARGUMENTO_DESCRIPCION_PUEBLO));
        editNHabitantes.setText(String.valueOf(this.getArguments().getInt(ARGUMENTO_N_HABITANTES)));
    }




}