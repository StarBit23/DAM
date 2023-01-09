package com.pmdm.virgen.pueblosconnavigationdraweb;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityLogin extends AppCompatActivity {
private Button btnLogin;
private EditText userEdit, passwordEdit;
private SharedPreferences shared;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);
        btnLogin = findViewById(R.id.buttoAcceder);

        userEdit = findViewById(R.id.edit_correo);
        passwordEdit = findViewById(R.id.edit_contraseña);

        inicializarCampos();
        cargarPreferenciasCompartidas();

        if(islogeado()){
            Intent i = new Intent(this,MainActivity.class);
            startActivity(i);
        }

        //iniciarLogin();



        //tonteria de login
        String Usuario = "pepe";
        String Password = "pepe";

            btnLogin.setOnClickListener(v -> {
                if(userEdit.getText().toString().equals(Usuario) && passwordEdit.getText().toString().equals(Password)) {
                    Intent intentLogin = new Intent(MainActivityLogin.this, MainActivity.class);
                    startActivity(intentLogin);
                }else {
                    Toast.makeText(MainActivityLogin.this, "Pon bien tu cuenta tonto", Toast.LENGTH_SHORT).show();
                }

            });


    }

    private void inicializarCampos() {

    }

    private void iniciarLogin(View view) {
        String email = userEdit.getText().toString();
        String pass = passwordEdit.getText().toString();
        userEdit.setText("");
        passwordEdit.setText("");

        if (email.equals("pepe") && pass.equals("pepe")){
            SharedPreferences.Editor editor = shared.edit();
            editor.putString("preferenciasEmail", email);
            editor.putBoolean("isLogin",true);
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);

        }else
            Toast.makeText(this, "Email y/o password incorrectos", Toast.LENGTH_SHORT).show();
    }


    private void cargarPreferenciasCompartidas() {
        String ficheroPreferencias = "appPreferencias";

        shared = this.getSharedPreferences(ficheroPreferencias, Context.MODE_PRIVATE);
    }

    private boolean islogeado() {
        Boolean isLogin = shared.getBoolean("isLogin",false);
        return isLogin;
    }
}