package com.example.miproyectofinal.dialog;

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

import com.example.miproyectofinal.R;
import com.example.miproyectofinal.fragment.SecondFragment;
import com.example.miproyectofinal.listener.OnJuegoDialogInteractionListener;
import com.example.miproyectofinal.model.Juego;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EditarJuegoDialogo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditarJuegoDialogo extends AppCompatDialogFragment {

    /**
     * Son los Argumentos que pasaremos desde el Activity.
     */
    public static final String ARGUMENTO_ID_JUEGO = Juego.ARGUMENTO_ID;
    public static final String ARGUMENTO_NOMBRE_JUEGO = Juego.ARGUMENTO_NOMBRE;
    public static final String ARGUMENTO_DESCRIPCION_JUEGO = Juego.ARGUMENTO_DESCRIPCION;
    public static final String ARGUMENTO_NUM_VENTAS_JUEGO = Juego.ARGUMENTO_NUM_VENTAS;
    public static final String ARGUMENTO_URL_FOTO = Juego.ARGUMENTO_URL_FOTO;
    private Context contexto;

    private EditText editNombre, editDescripcion, editVentas;
    private ImageView imgFoto;
    private OnJuegoDialogInteractionListener listener;

    public EditarJuegoDialogo(SecondFragment secondFragment) {
        listener = (OnJuegoDialogInteractionListener) secondFragment;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     */
    // TODO: Rename and change types and number of parameters
    public static EditarJuegoDialogo newInstance(SecondFragment secondFragment, long id, String nombre, String descripcion, String ventas, String urlFoto) {
        EditarJuegoDialogo dialogo = new EditarJuegoDialogo(secondFragment);
        Bundle args = new Bundle();
        // Pasamos los datos del pueblo, a los argumentos del Dialog para que sean recuperados.
        args.putLong(ARGUMENTO_ID_JUEGO, id);
        args.putString(ARGUMENTO_NOMBRE_JUEGO, nombre);
        args.putString(ARGUMENTO_DESCRIPCION_JUEGO, descripcion);
        args.putString(ARGUMENTO_NUM_VENTAS_JUEGO, ventas);
        //args.putString(ARGUMENTO_URL_FOTO, urlFoto);

        dialogo.setArguments(args);
        return dialogo;

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        contexto = context;
        if (contexto instanceof OnJuegoDialogInteractionListener){
            listener = (OnJuegoDialogInteractionListener) context;
        }else{
            //throw new IllegalArgumentException("Este contexto no implementa la interfaz OnJuegoActionListener");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View vista = inflater.inflate(R.layout.formulario_editar_juego_dialogo, null);  //inflamos la vista.
        inicializarCampos(vista);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(vista)
                .setTitle("Datos del Juego")
                .setNegativeButton("Cancelar",
                        (dialogo, i) ->{
                            EditarJuegoDialogo.this.dismiss();
                        }

                )
                .setPositiveButton("Guardar",
                        (dialogo, i) ->{
                            String nombre = editNombre.getText().toString();
                            String descripcion = editDescripcion.getText().toString();
                            String scuderia = editVentas.getText().toString();

                            if (nombre.isEmpty() || descripcion.isEmpty() || scuderia.isEmpty())
                                Toast.makeText(contexto, "Los campos no pueden estar vacíos", Toast.LENGTH_SHORT).show();
                            else{
                                long id = EditarJuegoDialogo.this.getArguments().getLong(ARGUMENTO_ID_JUEGO);
                                listener.editarJuego(id, nombre, descripcion, scuderia);
                                EditarJuegoDialogo.this.dismiss();
                            }

                        });
        return builder.create();
    }

    private void inicializarCampos(View vista) {
        editNombre = vista.findViewById(R.id.edit_nombre);
        editDescripcion = vista.findViewById(R.id.edit_descripcion);
        editVentas = vista.findViewById(R.id.edit_ventas);
        imgFoto = vista.findViewById(R.id.imageViewJuego);

        /*
        Seteamos los campos de la vista con los argumentos recibidos desde el Activity.
         */
        editNombre.setText(this.getArguments().getString(ARGUMENTO_NOMBRE_JUEGO));
        editDescripcion.setText(this.getArguments().getString(ARGUMENTO_DESCRIPCION_JUEGO));
        editVentas.setText(String.valueOf(this.getArguments().getInt(ARGUMENTO_NUM_VENTAS_JUEGO)));
    }
}