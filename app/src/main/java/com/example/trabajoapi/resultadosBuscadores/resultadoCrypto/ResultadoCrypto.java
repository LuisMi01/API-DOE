package com.example.trabajoapi.resultadosBuscadores.resultadoCrypto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.trabajoapi.APIClient;
import com.example.trabajoapi.Buscador;
import com.example.trabajoapi.dataBase.DataBaseHelper;
import com.example.trabajoapi.dataBase.Favoritos;
import com.example.trabajoapi.MainActivity;
import com.example.trabajoapi.R;
import com.example.trabajoapi.RepresentacionWebView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResultadoCrypto extends AppCompatActivity {
    private TextView nombbreCrypto;
    private TextView fechaCreacion;
    private Button botonFavoritos;
    private TextView precioCrypto;
    private TextView descripcionCrypto;
    private Button webCrypto;
    private ImageView imagenCrypto;
    private CryptoApi apiService;
    private CryptoBuscadorPOJO currentCrypto;
    private boolean isFavorite = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_crypto);

        obtenerDatosCrypto();

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

    public void obtenerDatosCrypto() {
        nombbreCrypto = findViewById(R.id.titulo_buscador_crypto);
        fechaCreacion = findViewById(R.id.fecha_salida_crypto);
        descripcionCrypto = findViewById(R.id.descripcion_crypto);
        precioCrypto = findViewById(R.id.valor_moneda_crypto);
        webCrypto = findViewById(R.id.link_web_crypto);
        imagenCrypto = findViewById(R.id.imagen_id_crypto);
        botonFavoritos = findViewById(R.id.boton_anadir_favoritos_crypto);
        // Configura Retrofit

        apiService = APIClient.getRetrofit().create(CryptoApi.class);

        // Realizar una solicitud a la API
        String cryptoId = getIntent().getStringExtra("cryptoId");
        Call<CryptoBuscadorPOJO> call = apiService.detallesMonedaBuscador(cryptoId);
        call.enqueue(new Callback<CryptoBuscadorPOJO>() {
            @Override
            public void onResponse(Call<CryptoBuscadorPOJO> call, Response<CryptoBuscadorPOJO> response) {
                if (response.isSuccessful()) {
                    CryptoBuscadorPOJO datosCrypto = response.body();
                    DescripcionCrypto description = datosCrypto.getDescription();
                    ValorMercadoCrypto market_data = datosCrypto.getMarket_data();
                    CurrentPrice current_price = market_data.getCurrent_price();
                    WebBuscadorCrypto links = datosCrypto.getLinks();
                    ImagenBuscadorCrypto image = datosCrypto.getImage();

                    if (datosCrypto != null) {
                        nombbreCrypto.setText(datosCrypto.getName());
                        fechaCreacion.setText("Fecha de creacion:\n" + datosCrypto.getGenesis_date());
                        descripcionCrypto.setText("Descripcion:\n" + description.getEn());
                        precioCrypto.setText("Valor de la moneda:\n" + current_price.getEur() + " €");
                        if (links != null) {
                            webCrypto.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    webCrypto.setText("Pagina web");
                                    Intent intent = new Intent(ResultadoCrypto.this, RepresentacionWebView.class);
                                    intent.putExtra("url", links.getHomepage().get(0));
                                    startActivity(intent);
                                }
                            });
                        }
                        if (image != null) {
                            String urlImagen = image.getSmall();
                            Glide.with(ResultadoCrypto.this).load(urlImagen).override(350, 350).into(imagenCrypto);
                        }

                        botonFavoritos.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                // Verificar si el objeto está en favoritos
                                boolean esFavorito = isFavorite(cryptoId, ResultadoCrypto.this);
                                // Actualizar la base de datos y cambiar el color del botón en consecuencia
                                if (esFavorito) {
                                    removeFromFavorites(cryptoId, ResultadoCrypto.this);
                                    // Cambiar el fondo del botón al predeterminado

                                    Toast.makeText(ResultadoCrypto.this, "Eliminado de favoritos", Toast.LENGTH_SHORT).show();
                                } else {
                                    addToFavorites(cryptoId, ResultadoCrypto.this);
                                    // Cambiar el fondo del botón a verde (o cualquier otro color)

                                    Toast.makeText(ResultadoCrypto.this, "Añadido a favoritos", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                } else {
                    nombbreCrypto.setText("Error en la solicitud.");
                }
            }

            @Override
            public void onFailure(Call<CryptoBuscadorPOJO> call, Throwable t) {
                Log.e("ERROR", t.getMessage());
            }
        });


    }

    private void removeFromFavorites(String nombreMoneda, Context context) {
        DataBaseHelper baseDatos = new DataBaseHelper(context);

        // Quitar de favoritos
        baseDatos.unmarkAsFavorite(nombreMoneda);
        baseDatos.close();

        // Mostrar un Toast o mensaje de confirmación si lo deseas
        Toast.makeText(context, "Eliminado de favoritos", Toast.LENGTH_SHORT).show();
        Log.d("Database", "Objeto eliminado de favoritos: " + nombreMoneda);
    }

    private boolean isFavorite(String nombreMoneda, Context context) {
        // Verificar si el objeto está en favoritos utilizando tu método isFavorite en DatabaseAPI
        DataBaseHelper baseDatos = new DataBaseHelper(context);
        boolean esFavorito = baseDatos.isFavorite(nombreMoneda);
        baseDatos.close();
        return esFavorito;

    }

    private void addToFavorites(String nombreMoneda, Context context) {
        DataBaseHelper baseDatos = new DataBaseHelper(context);
        // Añadir a favoritos
        baseDatos.markAsFavorite(nombreMoneda);
        baseDatos.close(); // Cerrar la base de datos

        // Puedes mostrar un Toast u otra retroalimentación aquí si lo deseas
        Toast.makeText(context, "Añadido a favoritos", Toast.LENGTH_SHORT).show();
        Log.d("Database", "Objeto añadido a favoritos: " + nombreMoneda);

    }

}
