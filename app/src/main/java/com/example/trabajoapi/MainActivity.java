package com.example.trabajoapi;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.trabajoapi.ranking.Ranking;
import com.example.trabajoapi.resultadosBuscadores.resultadoCrypto.CryptoApi;
import com.example.trabajoapi.resultadosBuscadores.resultadoCrypto.CryptoBuscadorPOJO;
import com.example.trabajoapi.resultadosBuscadores.resultadoCrypto.ResultadoCrypto;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView ping;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.imagen_principal);
        String urlImagen = "https://assets.stickpng.com/images/58428ed0a6515b1e0ad75ab6.png";
        Glide.with(MainActivity.this)
                .load(urlImagen).apply(new RequestOptions().centerCrop())
                .into(imageView);


        Button botonBuscador = findViewById(R.id.boton_home);
        botonBuscador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Ya se encuentra en la pantalla Home", Toast.LENGTH_LONG).show();
            }
        });

        findViewById(R.id.boton_buscador).setOnClickListener(view -> {
            Intent intent = new Intent(this, Buscador.class);
            startActivity(intent);
        });

        findViewById(R.id.boton_favoritos).setOnClickListener(view -> {
            Intent intent = new Intent(this, Favoritos.class);
            startActivity(intent);
        });

        findViewById(R.id.boton_ranking).setOnClickListener(view -> {
            Intent intent = new Intent(this, Ranking.class);
            startActivity(intent);
        });


        fetchResultadoCrypto();


    }

    public void fetchResultadoCrypto() {
        ping = findViewById(R.id.ping);

        MainActivityAPI apiService = APIClient.getRetrofit().create(MainActivityAPI.class);

        Call<MainActivityPOJO> call = apiService.getPing();
        call.enqueue(new Callback<MainActivityPOJO>() {
            @Override
            public void onResponse(Call<MainActivityPOJO> call, Response<MainActivityPOJO> response) {
                if (response.isSuccessful()) {
                    MainActivityPOJO pokemon = response.body();
                    if (pokemon != null) {
                        ping.setText("Versión de la API: " + pokemon.getGecko_says() );
                    }
                } else {
                    ping.setText("Error en la solicitud.");
                }

            }

            @Override
            public void onFailure(Call<MainActivityPOJO> call, Throwable t) {
                ping.setText("Error en la solicitud: " + t.getMessage());
            }
        });
    }


}