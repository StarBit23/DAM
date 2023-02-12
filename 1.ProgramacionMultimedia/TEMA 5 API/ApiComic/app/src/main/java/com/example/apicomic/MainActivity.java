package com.example.apicomic;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private final String BASE_URL="https://xkcd.com/";
    private ServicioPetrofitXkcd servicio;
    private Retrofit retrofit;
    ImageView imageViewComic;
    TextView txtTitulo;

    Button btnComic;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        crearInstanciaRetrofit();
        crearServicioPetrofit();
        mostrarComic();

        imageViewComic = findViewById(R.id.imageView);
        txtTitulo = findViewById(R.id.txtTitulo);
        btnComic = findViewById(R.id.btnComic);
        btnComic.setOnClickListener(v -> {
            mostrarComic();
        });
    }

    private void crearInstanciaRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private void crearServicioPetrofit() {
        servicio = retrofit.create(ServicioPetrofitXkcd.class);
    }

    private void mostrarComic() {
        Call<Comic> llamada = servicio.dameComic(
                new Random()
                        .nextInt(1000)
        );
        llamada.enqueue(new Callback<Comic>() {
            @Override
            public void onResponse(Call<Comic> call, Response<Comic> response) {
                try {
                    Comic comic = response.body();
                    txtTitulo.setText(comic.getTitle());
                    Picasso
                            .with(MainActivity.this)
                            .load(comic.getImg())
                            .into(imageViewComic);
                    Toast.makeText(MainActivity.this, response.message(), Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Log.e("MainActivity", e.toString());
                }
            }

            @Override
            public void onFailure(Call<Comic> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Ha habido algun error", Toast.LENGTH_LONG).show();
            }
        });
    }
}