package com.pmdm.virgen.pueblosconnavigationdraweb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.pmdm.virgen.pueblosconnavigationdraweb.listadoUsuarios.RealmHelper;
import com.pmdm.virgen.pueblosconnavigationdraweb.listadoUsuarios.Usuario;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class Register extends AppCompatActivity {

    private TextView txtUser;
    private TextView txtPass;
    private Button btnAceptar;
    private Button btnCancelar;

    public static AtomicLong IdJuego = new AtomicLong();
    RealmHelper realmHelper = new RealmHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrase);

        txtUser = findViewById(R.id.usuario_regis);
        txtPass = findViewById(R.id.contraseña_regis);
        btnAceptar = findViewById(R.id.boton_aceptar_regis);
        btnCancelar = findViewById(R.id.boton_cancelar_regis);

        inicializarRealm(getApplicationContext());
        Realm realm = Realm.getDefaultInstance();
        IdJuego = dameUltimoId(realm);


        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtUser!=null){
                    String stringUser = txtUser.getText().toString();
                    String stringPass = txtPass.getText().toString();

                    Intent intentVolver = new Intent(Register.this,LoginUsuario.class);

                    Usuario usuarioNuevo = new Usuario();
                    usuarioNuevo.setId((IdJuego.intValue())+1);
                    usuarioNuevo.setUsername(stringUser);
                    usuarioNuevo.setPassword(stringPass);
                    realmHelper.addUser(usuarioNuevo);

                    startActivity(intentVolver);
                }

            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentVolver2 = new Intent(Register.this,LoginUsuario.class);
                startActivity(intentVolver2);
            }
        });
    }

    private <T extends RealmObject > AtomicLong dameUltimoId(Realm realm) {
        RealmResults resultados = realm.where((Class<T>) Usuario.class).findAll();
        if (resultados.size()>0)
            return  new AtomicLong(Objects.requireNonNull(resultados.max("id")).intValue());
        else
            return  new AtomicLong();
    }

    private void inicializarRealm(Context contexto) {
        String realmName = "My Project";
        Realm.init(contexto);

        RealmConfiguration configuration = new RealmConfiguration.Builder().name(realmName).schemaVersion(1).deleteRealmIfMigrationNeeded().build();
        Realm.setDefaultConfiguration(configuration);
    }
}