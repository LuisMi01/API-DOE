package com.example.trabajoapi.ranking;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.trabajoapi.R;
import com.example.trabajoapi.buscadores.buscadorNft.NftPOJO;
import com.example.trabajoapi.buscadores.buscadorNft.NftViewHolder;
import com.example.trabajoapi.resultadosBuscadores.resultadoNft.nftDetalle.NftDetalle;

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
        CryptoRankingPOJO data = dataList.get(position);
        holder.nombre_moneda.setText("Nomre:\n" +data.getCoins().getName());
        holder.score_moneda.setText("Score:\n" + data.getCoins().getScore());
        holder.precio_moneda.setText("Precio:\n"  +data.getCoins().getPrice() + "€");
        Glide.with(holder.itemView.getContext())
                .load(data.getCoins().getSmall())
                .apply(RequestOptions.circleCropTransform()).override(100, 100)
                .into(holder.imagen_moneda);
        holder.boton_favorito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //añadir a favoritos
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
