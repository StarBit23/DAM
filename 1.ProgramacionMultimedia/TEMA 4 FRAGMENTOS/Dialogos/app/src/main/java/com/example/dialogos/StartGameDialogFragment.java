package com.example.dialogos;

import static android.content.ContentValues.TAG;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

import androidx.fragment.app.DialogFragment;

public class StartGameDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Te gustan las patatas?")
                .setPositiveButton("Si", (dialogo , i)->{
                    Log.d(TAG,"to wenas");
                })
                .setNegativeButton("No",(dialogo2,i)->{
                    Log.d(TAG,"tas loco");
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}

