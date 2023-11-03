package com.example.trabajoapi.ranking;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
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

    }

    public void fetchRanking() {
        CoinGekoApi apiService = APIClient.getRetrofit().create(CoinGekoApi.class);
        Call<List<CryptoRankingPOJO>> call = apiService.getTrendingCryptos();

        call.enqueue(new Callback<List<CryptoRankingPOJO>>() {
            @Override
            public void onResponse(Call<List<CryptoRankingPOJO>> call, Response<List<CryptoRankingPOJO>> response) {
                if( response.isSuccessful() ) {
                    List<CryptoRankingPOJO> cryptos = response.body();
                    // tratar o pintar los resultados de la lista
                    CryptoRankingAdapter adapter = new CryptoRankingAdapter(cryptos);
                    recyclerView.setAdapter(adapter);
                } else {
                    Log.e("MAINACTIVITY_CONSUMOAPI", "Error en la respuesta: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<CryptoRankingPOJO>> call, Throwable t) {
                Toast.makeText(Ranking.this, "Error en la petición", Toast.LENGTH_LONG).show();
                Log.e("MAINACTIVITY_CONSUMOAPI", "Error en la solicitud: ", t);
            }
        });
    }
}
