package com.pmdm.virgen.pueblosconnavigationdraweb;

import static com.pmdm.virgen.pueblosconnavigationdraweb.ApiService.retrofit;

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

import com.pmdm.virgen.pueblosconnavigationdraweb.responses.ResponseAuth;
import com.pmdm.virgen.pueblosconnavigationdraweb.responses.ResponseRegister;
import com.pmdm.virgen.pueblosconnavigationdraweb.varios.ClaseGetToken;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityLogin extends AppCompatActivity {
private Button btnLogin, btnRegistro;
private EditText userEdit, passwordEdit;
private SharedPreferences shared;
public String tokenActualUsuario;
public String comprobarLoginDefinitivo;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);
        btnLogin = findViewById(R.id.buttoAcceder);
        btnRegistro = findViewById(R.id.buttonRegistrarse);

        userEdit = findViewById(R.id.edit_correo);
        passwordEdit = findViewById(R.id.edit_contraseña);

        inicializarCampos();
        cargaPreferenciasCompartidas();

        if (isLogueado()){
            Intent i = new Intent(this,MainActivity.class);
            startActivity(i);
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //iniciarLogin();
                conseguirTokenRetrofit();
            }
        });

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crearUsuarioRetrofit();
            }
        });

    }

    private void crearUsuarioRetrofit(){
        ApiService apiService = retrofit.create(ApiService.class);
        Usuario user = new Usuario( "lolo@gmail.com","lolo","lolo","","1");
        Call<ResponseRegister> call = apiService.createUser(user);
        call.enqueue(new Callback<ResponseRegister>() {
            @Override
            public void onResponse(Call<ResponseRegister> call, Response<ResponseRegister> response) {
                if (response.isSuccessful()) {
                    // la solicitud fue exitosa
                    Toast.makeText(MainActivityLogin.this, "Usuario creado correctamente", Toast.LENGTH_SHORT).show();
                } else {
                    // manejar el error
                    Toast.makeText(MainActivityLogin.this, "Error al crear el usuario", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<ResponseRegister> call, Throwable t) {
                // manejar el error
                Toast.makeText(MainActivityLogin.this, "Imposible conectar a la API, ¿kapasao?", Toast.LENGTH_SHORT).show();
                System.out.println(t.getLocalizedMessage());
                t.getCause();
            }
        });
    }

    public void conseguirTokenRetrofit(){
        ApiService apiService = retrofit.create(ApiService.class);
        ClaseGetToken newClaseGetToken = new ClaseGetToken("lolo@gmail.com","lolo");
        Call<ResponseAuth> call = apiService.getToken(newClaseGetToken);
        call.enqueue(new Callback<ResponseAuth>() {
            @Override
            public void onResponse(Call<ResponseAuth> call, Response<ResponseAuth> response) {
                if (response.isSuccessful()) {
                    // la solicitud fue exitosa
                        tokenActualUsuario = response.body().getToken();
                        comprobarLoginDefinitivo = response.body().getResult();
                        //Toast.makeText(MainActivityLogin.this, comprobarLoginDefinitivo, Toast.LENGTH_SHORT).show();
                        if (comprobarLoginDefinitivo.equals("ok")){
                            Toast.makeText(MainActivityLogin.this, "Login correcto ¡Bienvenido!", Toast.LENGTH_SHORT).show();
                            iniciarLogin();
                        }
                } else {
                    // manejar el error
                    Toast.makeText(MainActivityLogin.this, "Error al conseguir el token del usuario especificado, ponlo bien chacho", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<ResponseAuth> call, Throwable t) {
                Toast.makeText(MainActivityLogin.this, "Imposible conectar a la API, ¿kapasao?", Toast.LENGTH_SHORT).show();
                System.out.println(t.getLocalizedMessage());
                t.getCause();
            }
        });
    }

    private void inicializarCampos() {

    }

    public void iniciarLogin(){

        SharedPreferences.Editor editor = shared.edit();
        editor.putString("preferenciasToken",tokenActualUsuario);
        editor.putBoolean("isLogin",true);
        editor.commit();
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }

    private void cargaPreferenciasCompartidas() {
        String fichPreferencias = "preferenciasAppPueblos";
        shared = this.getSharedPreferences(fichPreferencias, Context.MODE_PRIVATE);
    }

    private boolean isLogueado() {
        Boolean isLogin = shared.getBoolean("isLogin",false);
        return isLogin;
    }
}