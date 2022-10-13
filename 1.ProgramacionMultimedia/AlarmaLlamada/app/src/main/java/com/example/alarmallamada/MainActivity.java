package com.example.alarmallamada;

import static android.Manifest.permission.CALL_PHONE;

import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.PackageManagerCompat;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Button btnAlarma, btnLlamada;
    private ImageView llamada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        asociarElementos();
        gestionarEventos();
        crearLlamada();
    }

    private void asociarElementos() {
        btnAlarma = findViewById(R.id.btn_alarma);
        btnLlamada = findViewById(R.id.btn_llamada);
        llamada = findViewById(R.id.view_llamada);
    }

    private void gestionarEventos() {
        btnAlarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearAlarma();
            }
        });

        btnLlamada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarLlamada();
            }
        });

        llamada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearLlamada();
            }
        });
    }

    private void crearAlarma() {
        Toast.makeText(this, "creamos alarma", Toast.LENGTH_SHORT).show();
        ArrayList <Integer> dias = new ArrayList<>(); //para que los dias funcionen en la alarma
        dias.add(Calendar.MONDAY);
        dias.add(Calendar.SUNDAY);
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
        intent.putExtra(AlarmClock.EXTRA_MESSAGE,"Levantate de tu siesta");
        intent.putExtra(AlarmClock.EXTRA_DAYS,dias);
        intent.putExtra(AlarmClock.EXTRA_HOUR,8);
        intent.putExtra(AlarmClock.EXTRA_MINUTES,30);
        try {
            startActivity(intent);
        }catch(ActivityNotFoundException e){
            Log.d("ERROR","No se ha podido crear la alarma");
        }
    }

    private void realizarLlamada() {
        Toast.makeText(this, "realizamos llamada", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + 674649944));
        try {
            startActivity(intent);
        }catch (ActivityNotFoundException e) {
            Log.d("ERROR","No se ha podido llamar a nadie");
        }

    }

    @SuppressLint("SuspiciousIndentation")
    private void crearLlamada() {
        Toast.makeText(this, "realizamos llamada 2", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Intent.ACTION_CALL);
        //intent.setData(Uri.parse("tel:" + 674649944));
        //if (intent.resolveActivity(getPackageManager()) != null) {
        //    startActivity(intent);
        //}
        //try {
        //    startActivity(intent);
        //}catch (ActivityNotFoundException e) {
        //    Log.d("ERROR","No se ha podido llamar a nadie");
        //}
        if (ContextCompat.checkSelfPermission(this,CALL_PHONE)== PackageManager.PERMISSION_GRANTED) {
            intent.setData(Uri.parse("tel:" + 674649944));
            try {
                     startActivity(intent);
                 }catch (ActivityNotFoundException e) {
                     Log.d("ERROR","No se ha podido llamar a nadie");
                     e.printStackTrace();
                 }
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            requestPermissions(new String[]{CALL_PHONE},111);
        }

    }


}