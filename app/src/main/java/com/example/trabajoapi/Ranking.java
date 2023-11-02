package com.example.trabajoapi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Ranking extends AppCompatActivity {
    private LinearLayout layout_ranking;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_ranking);

            findViewById(R.id.boton_home).setOnClickListener(view -> {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            });

            findViewById(R.id.boton_buscador).setOnClickListener(view -> {
                Intent intent = new Intent(this, Buscador.class);
                startActivity(intent);
            });
            findViewById(R.id.boton_favoritos).setOnClickListener(view -> {
                Intent intent = new Intent(this, Favoritos.class);
                startActivity(intent);
            });


            // Configurar Retrofit
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.coingecko.com/api/v3/").addConverterFactory(GsonConverterFactory.create()).build();


            CoinGekoApi coinGekoApi = retrofit.create(CoinGekoApi.class);


            Call<List<CryptoRankingPOJO>> call = coinGekoApi.getTrendingCryptos();
            call.enqueue(new Callback<List<CryptoRankingPOJO>>() {
                @Override
                public void onResponse(Call<List<CryptoRankingPOJO>> call, Response<List<CryptoRankingPOJO>> response) {
                    if (response.isSuccessful()) {
                        List<CryptoRankingPOJO> cryptos = response.body();

                        // Procesar la lista de criptomonedas y mostrarla en el LinearLayout
                        for (CryptoRankingPOJO crypto : cryptos) {
                            TextView textView = new TextView(Ranking.this);
                            textView.setText(crypto.getName() + " (" + crypto.getPrice() + ")");
                            layout_ranking.addView(textView);
                        }
                    } else {
                        // Manejar la respuesta no exitosa
                    }
                }

                @Override
                public void onFailure(Call<List<CryptoRankingPOJO>> call, Throwable t) {
                    // Manejar el error de la solicitud

                }

            });


        }
}
