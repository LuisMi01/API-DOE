package com.example.trabajoapi.buscadores;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.trabajoapi.Buscador;
import com.example.trabajoapi.Favoritos;
import com.example.trabajoapi.MainActivity;
import com.example.trabajoapi.R;

public class BuscadorPrecios extends AppCompatActivity{

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_buscador_precios);

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
}
