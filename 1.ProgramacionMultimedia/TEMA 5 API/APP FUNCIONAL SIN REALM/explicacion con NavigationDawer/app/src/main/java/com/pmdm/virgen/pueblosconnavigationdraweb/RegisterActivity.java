package com.pmdm.virgen.pueblosconnavigationdraweb;

import static com.pmdm.virgen.pueblosconnavigationdraweb.ApiService.apiService;
import static com.pmdm.virgen.pueblosconnavigationdraweb.ApiService.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.pmdm.virgen.pueblosconnavigationdraweb.responses.ResponseRegister;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    private Button btnCancelar, btnAceptar;
    private TextView txtUser, txtPass, txtNombre;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtUser = findViewById(R.id.usuario_regis);
        txtPass = findViewById(R.id.contraseña_regis);
        txtNombre = findViewById(R.id.nombre_regis);

        btnAceptar = findViewById(R.id.boton_aceptar_regis);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtUser!=null){
                    Intent intentVolver = new Intent(RegisterActivity.this,MainActivityLogin.class);



                    crearUsuarioRetrofit();
                    startActivity(intentVolver);
                }

            }
        });

        btnCancelar = findViewById(R.id.boton_cancelar_regis);
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void crearUsuarioRetrofit(){
        ApiService apiService = retrofit.create(ApiService.class);
        //Recoger datos escritos en el register
        String stringUser = txtUser.getText().toString();
        String stringPass = txtPass.getText().toString();
        String stringNombre = txtNombre.getText().toString();

        Usuario usuarioNuevo = new Usuario( stringUser,stringPass,stringNombre,"","1");

        //Realizar la creacion del usuario retrofit
        Call<ResponseRegister> call = apiService.createUser(usuarioNuevo);
        call.enqueue(new Callback<ResponseRegister>() {
            @Override
            public void onResponse(Call<ResponseRegister> call, Response<ResponseRegister> response) {
                if (response.isSuccessful()) {
                    // la solicitud fue exitosa
                    Toast.makeText(RegisterActivity.this, "Usuario creado correctamente", Toast.LENGTH_SHORT).show();
                } else {
                    // manejar el error
                    Toast.makeText(RegisterActivity.this, "Error al crear el usuario", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<ResponseRegister> call, Throwable t) {
                // manejar el error
                Toast.makeText(RegisterActivity.this, "Imposible conectar a la API, ¿kapasao?", Toast.LENGTH_SHORT).show();
                System.out.println(t.getLocalizedMessage());
                t.getCause();
            }
        });
    }
}