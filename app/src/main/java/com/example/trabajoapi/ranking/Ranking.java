package com.example.trabajoapi.ranking;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.trabajoapi.APIClient;
import com.example.trabajoapi.Buscador;
import com.example.trabajoapi.Favoritos;
import com.example.trabajoapi.MainActivity;
import com.example.trabajoapi.R;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Ranking extends AppCompatActivity {

    private RecyclerView recyclerView;

    private CryptoRankingAdapter adapter;

    private List<CryptoRankingPOJO> dataList;

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

        recyclerView = findViewById(R.id.cajon_moneda);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        fetchCryptoRanking();
    }

    private void fetchCryptoRanking() {
            CoinGekoApi apiService = APIClient.getRetrofit().create(CoinGekoApi.class);
            Call<List<CryptoRankingPOJO>> call = apiService.getRankingCoins();
            call.enqueue(new Callback<List<CryptoRankingPOJO>>() {
                @Override
                public void onResponse(Call<List<CryptoRankingPOJO>> call, Response<List<CryptoRankingPOJO>> response) {
                    dataList = response.body();
                    adapter = new CryptoRankingAdapter(dataList);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }

                @Override
                public void onFailure(Call<List<CryptoRankingPOJO>> call, Throwable t) {
                    Log.d("CryptoRanking", t.getMessage());
                }
            });
        }
}
