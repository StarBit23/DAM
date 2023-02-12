package com.example.aplicacionjuegosfinal.dialogos;

import android.app.AlertDialog;
import android.content.Context;

import com.example.aplicacionjuegosfinal.listener.OnJuegoInteractionDialogListener;
import com.example.aplicacionjuegosfinal.ui.juegos.JuegoFragment;

public class DialogoConfirmacion {


    public static void newInstance(Context contexto, JuegoFragment frag, long id){
        AlertDialog.Builder builder = new AlertDialog.Builder(contexto);
        builder.setTitle("Eliminación del Juego");
        builder.setMessage("¿Desea eliminar ese juego?");
        builder.setPositiveButton("Si",
                (dialogo, i)->{
                    OnJuegoInteractionDialogListener mListener = (OnJuegoInteractionDialogListener) frag;
                    mListener.eliminarJuego(id);
                    dialogo.dismiss();
                });
        builder.setNegativeButton("Cancelar",
                (dialogo, i)->{
                    dialogo.dismiss();
                });
        AlertDialog dialogo = builder.create();
        dialogo.show();

    }
}
