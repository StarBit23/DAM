package com.pmdm.virgen.pueblosconnavigationdraweb;

import androidx.appcompat.app.AppCompatActivity;

import io.realm.Realm;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.pmdm.virgen.pueblosconnavigationdraweb.listadoUsuarios.RealmHelper;
import com.pmdm.virgen.pueblosconnavigationdraweb.listadoUsuarios.Usuario;

public class LoginUsuario extends AppCompatActivity {

    private Button entrarSinReg;
    private Button botonDeRegistro;
    RealmHelper realmHelper = new RealmHelper(this);
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;

    //private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_usuario);

        // Obtener las referencias a los elementos de la interfaz de usuario
        usernameEditText = findViewById(R.id.username_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        entrarSinReg = findViewById(R.id.buttonSinRegistro);
        botonDeRegistro = findViewById(R.id.botonDeRegistro);
        loginButton = findViewById(R.id.login_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Obtener el nombre de usuario y la contraseña ingresados por el usuario
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                //Buscar en la base de datos el usuario con el nombre de usuario ingresado
                Usuario user = realmHelper.getUser(username);

                //Verificar si el usuario existe y si la contraseña es correcta
                if (user.getUsername() != null && user.getPassword().equals(password)) {
                    Intent intentPrincipal = new Intent(LoginUsuario.this, MainActivity.class);
                    startActivity(intentPrincipal);
                    } else
                        Toast.makeText(LoginUsuario.this, "Nombre de usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                    //Si las credenciales no son válidas, mostrar un mensaje de error

            }
        });

        entrarSinReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginUsuario.this,MainActivity.class);
                startActivity(intent);
                Toast.makeText(LoginUsuario.this, "Entrando sin registrar...", Toast.LENGTH_SHORT).show();
            }
        });

        botonDeRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(LoginUsuario.this, Register.class);
                startActivity(a);
            }
        });
    }
}
