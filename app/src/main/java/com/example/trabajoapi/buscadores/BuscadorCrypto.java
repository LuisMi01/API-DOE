package com.example.trabajoapi.buscadores;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.trabajoapi.Buscador;
import com.example.trabajoapi.Favoritos;
import com.example.trabajoapi.MainActivity;
import com.example.trabajoapi.R;
import com.example.trabajoapi.resultadosBuscadores.resultadoCrypto.ResultadoCrypto;
import com.google.android.material.textfield.TextInputEditText;

public class BuscadorCrypto extends AppCompatActivity{

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_buscador_crypto);

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

            TextInputEditText texto = findViewById(R.id.input_buscador_crypto);


            if(texto.getText().toString().equals("")){
                texto.setError("Introduce una moneda");
            }
            else{
                findViewById(R.id.boton_buscador_crypto).setOnClickListener(view -> {
                    Intent intent = new Intent(this, ResultadoCrypto.class);
                    startActivity(intent);
                });
            }






        }
}
