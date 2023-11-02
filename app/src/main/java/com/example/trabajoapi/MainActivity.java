package com.example.trabajoapi;

import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import android.content.Intent;
import android.widget.Button;
import android.widget.ImageView;

import android.os.Bundle;

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

        Button buscador = findViewById(R.id.boton_buscador);
        buscador.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Buscador.class);
            startActivity(intent);
        });
    }




}