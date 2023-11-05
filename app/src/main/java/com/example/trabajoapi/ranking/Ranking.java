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
import java.util.ArrayList;
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
        recyclerView.setAdapter(adapter);

        fetchMonedas();
    }

    private void fetchMonedas() {
        CoinGekoApi apiService = APIClient.getRetrofit().create(CoinGekoApi.class);
        Call<CryptoDataResponse> call = apiService.getTrendingCryptos();

        call.enqueue(new Callback<CryptoDataResponse>() {
            @Override
            public void onResponse(@NonNull Call<CryptoDataResponse> call, @NonNull Response<CryptoDataResponse> response) {
                if( response.isSuccessful() ) {
                    CryptoDataResponse cryptoDataResponse = response.body();
                    List<CryptoRankingPOJO> cryptoRankingPOJOList = new ArrayList<>();
                    if (cryptoDataResponse != null) {
                        cryptoRankingPOJOList = cryptoDataResponse.getCoins();
                    }
                    CryptoRankingAdapter adapter = new CryptoRankingAdapter(cryptoRankingPOJOList);
                    recyclerView.setAdapter(adapter);
                } else {
                    Log.e("RESPUESTA", "Error en la respuesta: " + response.code());
                }
            }

            @Override
            public void onFailure(@NonNull Call<CryptoDataResponse> call, @NonNull Throwable t) {
                Toast.makeText(Ranking.this, "Error en la petición", Toast.LENGTH_LONG).show();
                Log.e("SOLICITUD", "Error en la solicitud: ", t);
            }
        });

    }
}
