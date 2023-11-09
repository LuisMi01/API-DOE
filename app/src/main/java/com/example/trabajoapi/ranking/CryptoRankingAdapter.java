package com.example.trabajoapi.ranking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.trabajoapi.R;
import com.example.trabajoapi.dataBase.DataBaseHelper;

import java.util.List;

public class CryptoRankingAdapter extends RecyclerView.Adapter<CryptoRankingViewHolder>{


    private List<Coin> dataList;

    public CryptoRankingAdapter(List<Coin> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public CryptoRankingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_tarjeta_ranking_monedas, parent, false);
        return new CryptoRankingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CryptoRankingViewHolder holder, int position) {
        Coin coin = dataList.get(position);
        Item item = coin.getItem();

        holder.nombre_moneda.setText("Nombre\n" + item.getName());
        holder.score_moneda.setText("Ranking\n#" + item.getScore());
        holder.precio_moneda.setText("Precio\n" + item.getPrice_btc() + " BTC");

        Glide.with(holder.itemView.getContext())
                .load(item.getSmall())
                .apply(RequestOptions.circleCropTransform()).override(400, 400)
                .into(holder.imagen_moneda);

        holder.boton_favorito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToFavorites(item.getName(), holder.itemView.getContext());
            }
        });
    }

    private void addToFavorites(String nombreMoneda, Context context) {
        DataBaseHelper baseDatos = new DataBaseHelper(context);

        // Añadir a favoritos
        baseDatos.open();  // Abrir la base de datos
        baseDatos.markAsFavorite(nombreMoneda);
        baseDatos.close(); // Cerrar la base de datos

        // Puedes mostrar un Toast u otra retroalimentación aquí si lo deseas
        Toast.makeText(context, "Añadido a favoritos", Toast.LENGTH_SHORT).show();
    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }
}


