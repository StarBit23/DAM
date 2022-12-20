package com.example.miproyectofinal;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityLogin extends AppCompatActivity {
private Button btnLogin;
private EditText userEdit, passwordEdit;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);
        btnLogin = findViewById(R.id.buttoAcceder);

        userEdit = findViewById(R.id.edit_correo);
        passwordEdit = findViewById(R.id.edit_contraseña);

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
}