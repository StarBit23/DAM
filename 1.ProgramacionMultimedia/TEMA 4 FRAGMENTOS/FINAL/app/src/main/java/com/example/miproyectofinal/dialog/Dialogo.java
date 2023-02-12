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

import com.example.miproyectofinal.MainActivity;
import com.example.miproyectofinal.R;
import com.example.miproyectofinal.fragment.SecondFragment;
import com.example.miproyectofinal.listener.OnJuegoDialogInteractionListener;

public class Dialogo extends AppCompatDialogFragment
{
    private EditText editNombre, editDescripcion, editVentas;
    private ImageView imgFoto;
    private Context contexto;
    private OnJuegoDialogInteractionListener listener;
    private MainActivity activity;

    public Dialogo(SecondFragment secondFragment){
        listener = (OnJuegoDialogInteractionListener) secondFragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        activity = (MainActivity) context;
        /*try{
            listener = (OnPilotoDialogInteractionListener) contexto;
        }catch(ClassCastException e){
            throw new ClassCastException(context.toString() + "Necesita implementar la interfaz OnPilotoInteractionListener");
        }*/
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());  // o getActivity()
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View vista = inflater.inflate(R.layout.formulario_juegos, null);
        asociaCampos(vista);
        builder.setView(vista)
                .setTitle("Nuevo Juego")
                .setNegativeButton("Cancelar",
                        (dialogo, i )->{
                            Toast.makeText(activity, "Se ha cancelado la inserción", Toast.LENGTH_SHORT).show();
                            dialogo.dismiss();
                        }

                )
                //De momento, el tema de la foto para los pueblos, lo dejamos sin utilizar. Ya tenemos bastante...
                .setPositiveButton("Añadir",
                        (dialogo,i)->{
                            String nombre = editNombre.getText().toString();
                            String descripcion = editDescripcion.getText().toString();
                            String ventas = editVentas.getText().toString();
                            String url = "";

                            if (nombre.isEmpty() || descripcion.isEmpty() || ventas.isEmpty())
                                Toast.makeText(activity, "Campos incorrectos", Toast.LENGTH_SHORT).show();
                            else
                                listener.insertarJuego(nombre, descripcion, ventas);
                            dialogo.dismiss();
                        }
                );
        return builder.create();

    }

    public void asociaCampos(View vista){
        editNombre = (EditText) vista.findViewById(R.id.edit_nuevo_nombre_piloto);
        editDescripcion = (EditText) vista.findViewById(R.id.edit_nueva_descripcion);
        editVentas = (EditText) vista.findViewById(R.id.edit_nueva_venta);
    }
}