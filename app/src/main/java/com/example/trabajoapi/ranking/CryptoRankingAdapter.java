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
    private final List<CryptoRankingPOJO> cryptoRankingPOJOList;

    public CryptoRankingAdapter(List<CryptoRankingPOJO> cryptoRankingPOJOList) {
        this.cryptoRankingPOJOList = cryptoRankingPOJOList;
        Log.d("CryptoRankinngAdapter", cryptoRankingPOJOList.toString());
    }

     @NonNull
     @Override
     public CryptoRankingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_tarjeta_ranking_monedas, parent, false);
         return new CryptoRankingViewHolder(view);
     }


    @Override
    public void onBindViewHolder(@NonNull CryptoRankingViewHolder holder, int position) {
        CryptoRankingPOJO cryptoRankingPOJO = cryptoRankingPOJOList.get(position);
        holder.nombre_moneda.setText(cryptoRankingPOJO.getName());
        holder.score_moneda.setText(String.valueOf(cryptoRankingPOJO.getScore()));
        holder.precio_moneda.setText(String.valueOf(cryptoRankingPOJO.getPrice()));
        Glide.with(holder.itemView.getContext())
                .load(cryptoRankingPOJO.getImage())
                .apply(new RequestOptions().placeholder(R.drawable.ic_launcher_background))
                .into(holder.imagen_moneda);
        holder.boton_favorito.setText(String.valueOf(cryptoRankingPOJO.isFavorito()));
    }

    @Override
    public int getItemCount() {
        return cryptoRankingPOJOList.size();
    }
}
