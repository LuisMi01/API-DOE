package com.example.trabajoapi.ranking;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabajoapi.APIClient;
import com.example.trabajoapi.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Ranking extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        recyclerView = (RecyclerView) findViewById(R.id.cajon_moneda);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        fetchRanking();
    }

    public void fetchRanking() {
        CoinGekoApi apiService = APIClient.getRetrofit().create(CoinGekoApi.class);
        Call<CryptoDataResponse> call = apiService.getTrendingCryptos();
        call.enqueue(new Callback<CryptoDataResponse>() {
            @Override
            public void onResponse(Call<CryptoDataResponse> call, Response<CryptoDataResponse> response) {
                if (response.isSuccessful()) {
                    CryptoDataResponse cryptoDataResponse = response.body();
                    if (cryptoDataResponse != null) {
                        List<CryptoRankingPOJO> cryptos = cryptoDataResponse.getCoins();
                        if (cryptos != null) {
                            CryptoRankingAdapter adapter = new CryptoRankingAdapter(cryptos);
                            recyclerView.setAdapter(adapter);
                        } else {
                            Log.e("MAINACTIVITY_CONSUMOAPI", "La lista de criptomonedas es nula en la respuesta.");
                        }
                    } else {
                        Log.e("MAINACTIVITY_CONSUMOAPI", "La respuesta de la API es nula.");
                    }
                } else {
                    Log.e("MAINACTIVITY_CONSUMOAPI", "Error en la respuesta: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<CryptoDataResponse> call, Throwable t) {
                Toast.makeText(Ranking.this, "Error en la petición", Toast.LENGTH_LONG).show();
                Log.e("MAINACTIVITY_CONSUMOAPI", "Error en la solicitud: ", t);
            }
        });
    }
}
