package com.pmdm.virgen.pueblosconnavigationdraweb.dialogos;

import android.app.AlertDialog;
import android.content.Context;

import com.pmdm.virgen.pueblosconnavigationdraweb.listener.OnPuebloInteractionDialogListener;
import com.pmdm.virgen.pueblosconnavigationdraweb.ui.pueblos.PuebloFragment;

public class DialogoConfirmacion {


    public static void newInstance(Context contexto, PuebloFragment frag, long id){
        AlertDialog.Builder builder = new AlertDialog.Builder(contexto);
        builder.setTitle("Eliminación del Pueblo");
        builder.setMessage("¿Desea eliminar ese pueblo?");
        builder.setPositiveButton("Si",
                (dialogo, i)->{
                    OnPuebloInteractionDialogListener mListener = (OnPuebloInteractionDialogListener) frag;
                    mListener.eliminarPueblo(id);
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
