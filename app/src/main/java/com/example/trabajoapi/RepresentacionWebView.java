package com.example.trabajoapi;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.trabajoapi.dataBase.Favoritos;

public class RepresentacionWebView extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plantilla_web);

        webView = findViewById(R.id.web_view);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setMixedContentMode(webSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        webView.clearCache(true);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        webView.loadUrl(url);

        volver();

    }

    public void volver(){
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
