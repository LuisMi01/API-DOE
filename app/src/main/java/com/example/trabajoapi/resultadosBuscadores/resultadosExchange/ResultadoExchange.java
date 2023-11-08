package com.example.trabajoapi.resultadosBuscadores.resultadosExchange;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.example.trabajoapi.APIClient;
import com.example.trabajoapi.Buscador;
import com.example.trabajoapi.dataBase.Favoritos;
import com.example.trabajoapi.MainActivity;
import com.example.trabajoapi.R;
import com.example.trabajoapi.RepresentacionWebView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResultadoExchange extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_exchange);

        obtenerDatosExchange();

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

    }

    public void obtenerDatosExchange() {
        TextView nombreExchange = findViewById(R.id.titulo_buscador_exchange);
        TextView fechaCreacionExchange = findViewById(R.id.fecha_salida_exchange);
        TextView descripcionExchange = findViewById(R.id.descripcion_exchange);
        TextView paisExchange = findViewById(R.id.pais_nacimiento_exchange);
        Button webExchange = findViewById(R.id.link_web_exchange);
        ImageView imagenExchange = findViewById(R.id.imagen_id_exchange);

        // Configura Retrofit
        ExchangeApi apiService = APIClient.getRetrofit().create(ExchangeApi.class);

        // Realizar una solicitud a la API
        String ExchangeId = getIntent().getStringExtra("ExchangeId");
        Call<ExchangeBuscadorPOJO> call = apiService.detallesExchangeBuscador(ExchangeId);
        call.enqueue(new Callback<ExchangeBuscadorPOJO>() {
            @Override
            public void onResponse(Call<ExchangeBuscadorPOJO> call, Response<ExchangeBuscadorPOJO> response) {
                if (response.isSuccessful()) {
                    ExchangeBuscadorPOJO datosExchange = response.body();

                    if (datosExchange != null) {
                        nombreExchange.setText(datosExchange.getName());
                        fechaCreacionExchange.setText("Fecha de creacion:\n" + datosExchange.getYear_stablished());
                        descripcionExchange.setText("Descripcion:\n" + datosExchange.getDescription());
                        paisExchange.setText("Pais de residencia:\n" + datosExchange.getCountry());
                            if (webExchange != null) {
                                webExchange.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        webExchange.setText("Pagina web");
                                        Intent intent = new Intent(ResultadoExchange.this, RepresentacionWebView.class);
                                        intent.putExtra("url", datosExchange.getUrl());
                                        startActivity(intent);
                                    }
                                });
                            } else {
                                webExchange.setText("Pagina web:\n" + "No disponible");
                            }

                        if (imagenExchange != null) {
                            String urlImagen = datosExchange.getImage();
                            Glide.with(ResultadoExchange.this).load(urlImagen).override(400, 400).into(imagenExchange);
                        }
                    }
                } else {
                    nombreExchange.setText("Error en la solicitud.");
                }
            }

            @Override
            public void onFailure(Call<ExchangeBuscadorPOJO> call, Throwable t) {
                Log.e("ERROR", t.getMessage());
            }
        });
    }

}


