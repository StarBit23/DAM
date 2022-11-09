package com.example.ejemplo3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
RadioGroup ciudadesGroup;
Button btn1;
ImageView imgJaen;
ImageView imgSevilla;
ImageView imgAlbacete;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgJaen = findViewById(R.id.img_jaen);
        imgSevilla = findViewById(R.id.img_sevilla);
        imgAlbacete = findViewById(R.id.imgAlbacete);
        btn1 = findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conocerOpcion();
            }
        });
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

    public void conocerOpcion(){
        ciudadesGroup = findViewById(R.id.radiog_ciudad);
        int idSeleccionado = ciudadesGroup.getCheckedRadioButtonId();
        String msg2 = "";
        if (idSeleccionado == R.id.radioButton){
            msg2 = "Has seleccionado trabajar en Jaén, Jaén ni pollas";
            imgJaen.setVisibility(View.VISIBLE);
            imgAlbacete.setVisibility(View.INVISIBLE);
            imgSevilla.setVisibility(View.INVISIBLE);
        }else if (idSeleccionado == R.id.radioButton2){
            msg2 = "Has seleccionado trabajar en Albacete, no te arrepentiras (feriaaa)";
            imgAlbacete.setVisibility(View.VISIBLE);
            imgJaen.setVisibility(View.INVISIBLE);
            imgSevilla.setVisibility(View.INVISIBLE);
        }else if (idSeleccionado == R.id.radioButton3){
            msg2 = "Has seleccionado trabajar en Sevilla, no ni naaaa";
            imgSevilla.setVisibility(View.VISIBLE);
            imgJaen.setVisibility(View.INVISIBLE);
            imgAlbacete.setVisibility(View.INVISIBLE);
        }
        Toast.makeText(this, msg2, Toast.LENGTH_SHORT).show();
    }

}