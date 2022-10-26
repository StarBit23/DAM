package com.example.alarmallamada;

import static android.Manifest.permission.CALL_PHONE;

import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PackageManagerCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Notification;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.net.URI;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private ImageView btnAlarma;
    private ImageView btnLlamada;
    private ImageView btnUrl;
    private ImageView btnSms;
    private ImageView llamada;
    String _url="https://www.youtube.com/watch?v=Ba3b5goqvv0&ab_channel=Kingprawn";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        asociarElementos();
        gestionarEventos();
        crearSms();
        //crearLlamada();
    }

    private void crearSms() {
        if(ActivityCompat.checkSelfPermission(
                MainActivity.this, Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED&& ActivityCompat.checkSelfPermission(
                MainActivity.this,Manifest
                        .permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this,new String[]
                    { Manifest.permission.SEND_SMS,},1000);
        }else{
        };
    }

    private void asociarElementos() {
        btnAlarma = findViewById(R.id.img_alarma);
        btnLlamada = findViewById(R.id.img_llamada);
        btnUrl = findViewById(R.id.img_url);
        btnSms = findViewById(R.id.img_sms);
        //llamada = findViewById(R.id.view_llamada);
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

        btnUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearUrl();
            }
        });

        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarSms("688926891","¡Hola, esta es una prueba de SMS para ti!");
            }
        });

//        llamada.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                crearLlamada();
//            }
//        });
    }

    private void enviarSms(String numero, String mensaje) {
        try {
            SmsManager sms = SmsManager.getDefault();

            sms.sendTextMessage(numero,null,mensaje,null,null);
            Toast.makeText(this, "Mensaje enviado", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(this, "Mensaje no enviado, datos incorrectos", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    private void crearUrl() {
        Uri _link = Uri.parse(_url);
        Intent i = new Intent(Intent.ACTION_VIEW,_link);
        startActivity(i);
    }

    private void crearAlarma() {
        Toast.makeText(this, "creamos alarma", Toast.LENGTH_SHORT).show();
        ArrayList <Integer> dias = new ArrayList<>(); //para que los dias funcionen en la alarma
        dias.add(Calendar.MONDAY);
        dias.add(Calendar.SUNDAY);
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
        intent.putExtra(AlarmClock.EXTRA_MESSAGE,"Levantate de tu siesta");
        intent.putExtra(AlarmClock.EXTRA_DAYS,dias);
        intent.putExtra(AlarmClock.EXTRA_HOUR,16);
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
        intent.setData(Uri.parse("tel:" + 688926891));
        try {
            startActivity(intent);
        }catch (ActivityNotFoundException e) {
            Log.d("ERROR","No se ha podido llamar a nadie");
        }

    }

//    @SuppressLint("SuspiciousIndentation")
//    private void crearLlamada() {
//        Toast.makeText(this, "realizamos llamada 2", Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent(Intent.ACTION_CALL);
//        //intent.setData(Uri.parse("tel:" + 674649944));
//        //if (intent.resolveActivity(getPackageManager()) != null) {
//        //    startActivity(intent);
//        //}
//        //try {
//        //    startActivity(intent);
//        //}catch (ActivityNotFoundException e) {
//        //    Log.d("ERROR","No se ha podido llamar a nadie");
//        //}
//        if (ContextCompat.checkSelfPermission(this,CALL_PHONE)== PackageManager.PERMISSION_GRANTED) {
//            intent.setData(Uri.parse("tel:" + 674649944));
//            try {
//                     startActivity(intent);
//                 }catch (ActivityNotFoundException e) {
//                     Log.d("ERROR","No se ha podido llamar a nadie");
//                     e.printStackTrace();
//                 }
//        } else {
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
//            requestPermissions(new String[]{CALL_PHONE},111);
//        }
//
//    }


}