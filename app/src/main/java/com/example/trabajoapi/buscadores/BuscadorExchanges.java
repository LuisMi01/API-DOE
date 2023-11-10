package com.example.trabajoapi.buscadores;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.trabajoapi.Buscador;
import com.example.trabajoapi.dataBase.Favoritos;
import com.example.trabajoapi.MainActivity;
import com.example.trabajoapi.R;
import com.example.trabajoapi.resultadosBuscadores.resultadosExchange.ResultadoExchange;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class BuscadorExchanges extends AppCompatActivity{

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_buscador_exchanges);

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


                TextInputEditText texto = findViewById(R.id.input_buscador_exchanges);
                findViewById(R.id.boton_buscador_exchanges).setOnClickListener(view -> {
                    String userInput = Objects.requireNonNull(texto.getText()).toString();
                    // Verifica si el campo de entrada no está vacío antes de continuar
                    if (!userInput.isEmpty()) {
                        // Crea una nueva intención y pasa el valor de entrada del usuario a la actividad ResultadoCrypto
                        Intent intent = new Intent(this, ResultadoExchange.class);
                        intent.putExtra("ExchangeId", userInput);
                        startActivity(intent);
                    } else {
                        // Muestra un mensaje de error al usuario si el campo está vacío
                        Toast.makeText(this, "Por favor, ingresa una moneda", Toast.LENGTH_LONG).show();
                    }
                });
            }
}
