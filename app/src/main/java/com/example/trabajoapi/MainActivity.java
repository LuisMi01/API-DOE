package com.example.trabajoapi;

import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.imagen_principal);
        String urlImagen = "https://assets.stickpng.com/images/58428ed0a6515b1e0ad75ab6.png";

        Glide.with(MainActivity.this)
                .load(urlImagen).apply(new RequestOptions().centerCrop())
                .into(imageView);





        Button botonBuscador = findViewById(R.id.boton_home);
        botonBuscador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Muestra un Toast cuando se pulsa el botón
                Toast.makeText(MainActivity.this, "Ya se encuentra en la pantalla Home", Toast.LENGTH_LONG).show();
            }
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