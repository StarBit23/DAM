package com.pmdm.virgen.pueblosconnavigationdraweb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.pmdm.virgen.pueblosconnavigationdraweb.listadoUsuarios.Usuario;

public class Register extends AppCompatActivity {

    private TextView txtUser;
    private TextView txtPass;
    private Button btnAceptar;
    private Button btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrase);

        txtUser = findViewById(R.id.usuario_regis);
        txtPass = findViewById(R.id.contraseña_regis);
        btnAceptar = findViewById(R.id.boton_aceptar_regis);
        btnCancelar = findViewById(R.id.boton_cancelar_regis);



        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtUser!=null){
                    String stringUser = txtUser.getText().toString();
                    String stringPass = txtPass.getText().toString();
                    //Usuario usuarioPrueba = new Usuario(stringUser, stringPass);

                    Intent intentVolver = new Intent(Register.this,LoginUsuario.class);
                    intentVolver.putExtra("nombre",stringUser);
                    intentVolver.putExtra("pass",stringPass);
                    startActivity(intentVolver);
                }

            }
        });
    }
}