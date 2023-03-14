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

        //preferencias compartidas=true? ==> acceder al activity sin login
        if (isLogueado()){
            Intent i = new Intent(this,MainActivity.class);
            startActivity(i);
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conseguirTokenRetrofit();
            }
        });

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startRegisterActivity();
                //crearUsuarioRetrofit();
            }
        });

    }

    private void startRegisterActivity() {
        Intent i = new Intent(this,RegisterActivity.class);
        startActivity(i);
    }

    public void conseguirTokenRetrofit(){
        ApiService apiService = retrofit.create(ApiService.class);
        ClaseGetToken newClaseGetToken = new ClaseGetToken(userEdit.getText().toString(),passwordEdit.getText().toString());
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
                    Toast.makeText(MainActivityLogin.this, "Correo y/o contraseña incorrectos, ponlo bien chacho", Toast.LENGTH_SHORT).show();
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
        editor.putString(getString(R.string.preferencias_token),tokenActualUsuario);
        editor.putBoolean("isLogin",true);
        editor.commit();
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }

    private void cargaPreferenciasCompartidas() {
        shared = getSharedPreferences(getString(R.string.preferencias_fichero_login), Context.MODE_PRIVATE);
    }

    private boolean isLogueado() {
        Boolean isLogin = shared.getBoolean("isLogin",false);
        return isLogin;
    }
}