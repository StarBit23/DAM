package com.example.miproyectofinal.dialog;

import android.app.AlertDialog;
import android.content.Context;

import com.example.miproyectofinal.fragment.SecondFragment;
import com.example.miproyectofinal.listener.OnJuegoDialogInteractionListener;

public class DialogoConfirmacion {


    public static void newInstance(Context contexto, SecondFragment secondFragment, long id){
        AlertDialog.Builder builder = new AlertDialog.Builder(contexto);
        builder.setTitle("Eliminación del Piloto");
        builder.setMessage("¿Desea eliminar este piloto?");
        builder.setPositiveButton("Si",
                (dialogo, i)->{
                    OnJuegoDialogInteractionListener mListener = (OnJuegoDialogInteractionListener) secondFragment;
                    mListener.borrarJuego(id);
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
