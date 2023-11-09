package com.example.trabajoapi.ranking;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.trabajoapi.R;
import java.util.List;

public class CryptoRankingAdapter extends RecyclerView.Adapter<CryptoRankingViewHolder>{

    private List<CryptoRankingPOJO> dataList;

    public CryptoRankingAdapter(List<CryptoRankingPOJO> dataList) {
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
        CryptoRankingPOJO coin = dataList.get(position);
        holder.nombre_moneda.setText("Nombre:\n" + coin.getItem().getName());
        holder.score_moneda.setText("Ranking:\n" + coin.getItem().getScore());
        holder.precio_moneda.setText("Precio:\n" + coin.getItem().getPrice() + " $");

        Glide.with(holder.itemView.getContext())
                .load(coin.getItem().getSmall())
                .apply(RequestOptions.circleCropTransform()).override(200, 200)
                .into(holder.imagen_moneda);

        holder.boton_favorito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //añadir a favoritos
            }
        });

        //Log.d("TAG", "onBindViewHolder: " + data.getCoins().getName() + " " + data.getCoins().getScore() + " " + data.getCoins().getPrice() + " " + data.getCoins().getSmall());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

}


