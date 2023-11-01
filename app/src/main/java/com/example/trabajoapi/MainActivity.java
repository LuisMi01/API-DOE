package com.example.trabajoapi;

import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import android.widget.ImageView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.imagen_principal);
        String urlImagen = "https://png.pngtree.com/png-clipart/20210404/original/pngtree-metal-bitcoin-png-image_6200465.jpg";

        Glide.with(MainActivity.this)
                .load(urlImagen).apply(new RequestOptions().centerCrop())
                .into(imageView);

    }




}