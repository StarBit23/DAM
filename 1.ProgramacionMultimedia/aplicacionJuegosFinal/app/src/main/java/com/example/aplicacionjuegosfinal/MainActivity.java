package com.example.aplicacionjuegosfinal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.aplicacionjuegosfinal.databinding.ActivityMainBinding;
import com.example.aplicacionjuegosfinal.modelos.Juego;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private RealmResults<Juego> listaJuego;
    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    private Fragment f = null;
    Realm realm;
    RealmResults<Juego> listaJuegos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        realm = Realm.getDefaultInstance();
        crearObjetosDinamicos();

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;    //aqui se muestra el navigation drawer
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_juegos)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.action_exit:
                Toast.makeText(this, "me piro😎", Toast.LENGTH_SHORT).show();
                cerrarSesion();
                return true;
            case R.id.action_settings:
                Toast.makeText(this, "opciones", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /*@Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getTitle().equals("Exit")){
            Toast.makeText(this, "me piro😎", Toast.LENGTH_SHORT).show();
            cerrarSesion();
        }
        return super.onOptionsItemSelected(item);
    }*/

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void cerrarSesion(){
        SharedPreferences sharedPreferences =
                getSharedPreferences(getString(R.string.preferencias_fichero_login), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
        finish();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    public void crearObjetosDinamicos(){
        listaJuegos = realm.where(Juego.class).findAll();
        //listaJuegos = new ArrayList<>();

        //listaJuegosBBDD = realm.where(Juego.class).findAll();

//        listaJuegos.add(new Juego(0,null, "Super Mario Bros","Plataforma: NES", "40,24 millones"));
//        listaJuegos.add(new Juego(1,null, "Super Mario 64", "Plataforma: Nintendo 64", "11,91 millones"));
//        listaJuegos.add(new Juego(2,null, "Super Mario Sunshine", "Plataforma: Gamecube", "6,28 millones"));
//        listaJuegos.add(new Juego(3,null, "Super Mario Galaxy","Plataforma: Wii", "12,79 millones"));
//        listaJuegos.add(new Juego(4,null, "Super Mario Galaxy 2","Plataforma: Wii", "12,79 millones"));
//        listaJuegos.add(new Juego(5,null, "Mario Party 8","Plataforma: Wii", "8,85 millones"));
//        listaJuegos.add(new Juego(6,null, "Super Mario 3D Land","Plataforma: Nintendo 3DS", "12,50 millones"));
//        listaJuegos.add(new Juego(7,null, "Super Mario Maker","Plataforma: Wii U", "4 millones"));
//        listaJuegos.add(new Juego(8,null, "New Super Mario Bros U","Plataforma: Wii U", "5,80 millones"));
//        listaJuegos.add(new Juego(9,null, "Mario Kart 8 Deluxe","Plataforma: Switch", "49 millones"));
//
//        for (int i=0; i<10; i++ )
//            Contador.increId();
    }
}