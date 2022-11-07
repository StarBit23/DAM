package com.example.ejemplo3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
RadioGroup ciudadesGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void tipoTrabajo(View view) {
        CheckBox checked = (CheckBox) view;
        String msg="";
        boolean pulsado = checked.isChecked();
        switch (view.getId()) {
            case R.id.checkBox1:
                msg = "Elegido Ingeniero";


            case R.id.checkBox2:
                msg = "Elegido Profesor";


            case R.id.checkBox3:
                msg = "Elegido Arquitecto";

        }
        Toast.makeText(this, msg+"("+pulsado+")", Toast.LENGTH_SHORT).show();
        trabajosSeleccionados();
    }

    private void trabajosSeleccionados() {
        CheckBox check1, check2, check3;
        check1 = findViewById(R.id.checkBox1);
        check2 = findViewById(R.id.checkBox2);
        check3 = findViewById(R.id.checkBox3);

        String msg="";
        if (check1.isChecked())
            msg+="Ingeniero";
        if (check2.isChecked())
            msg+="Profesor";
        if (check3.isChecked())
            msg+="Arquitecto";

        Toast.makeText(this, "Ya llevas "+ msg, Toast.LENGTH_SHORT).show();
    }

    public void conocerOpcion(View view){
        ciudadesGroup = findViewById(R.id.radiog_ciudad);
        String msg = "";
        int idSeleccionado = ciudadesGroup.getCheckedRadioButtonId();
        if (idSeleccionado == R.id.radioButton){
            msg = "Has seleccionado trabajar en Jaén,Jaén ni pollas";
        }else if (idSeleccionado == R.id.radioButton2){
            msg = "Has seleccionado trabajar en Albacete, no te arrepentiras (feriaaa)";
        }else if (idSeleccionado == R.id.radioButton3){
            msg = "Has seleccionado trabajar en Sevilla, no ni naaaa";
        }
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}