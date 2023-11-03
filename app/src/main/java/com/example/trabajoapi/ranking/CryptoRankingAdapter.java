package com.example.trabajoapi.ranking;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabajoapi.R;

import java.util.List;

public class CryptoRankingAdapter extends RecyclerView.Adapter<CryptoRankingViewHolder>{
    private List<CryptoRankingPOJO> cryptoRankingPOJOList;

    public CryptoRankingAdapter(List<CryptoRankingPOJO> cryptoRankingPOJOList) {
        this.cryptoRankingPOJOList = cryptoRankingPOJOList;
    }

    @NonNull
    @Override
    public CryptoRankingPOJO onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_ranking, parent, false);
        return new CryptoRankingPOJO(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        CryptoRankingPOJO crypto = cryptoRankingPOJOList.get(position);
//          holder.tv_id_pokemon.setText(pokemon.getId());
        holder.tv_pokemonName.setText(crypto.getName());
        holder.tv_type.setText(crypto.getType());
        holder.tv_height.setText(crypto.getHeight());
        holder.tv_weight.setText(pokemon.getWeight());
        holder.tv_others.setText(pokemon.getAdditionalProperties().toString());
        // en caso de que tuviéramos otros campos, podemos añadirlos
    }

    @Override
    public int getItemCount() {
        if( cryptoRankingPOJOList != null )
            return cryptoRankingPOJOList.size();
        Log.e("Crypto ADAPTER", "No tengo registros");
        return 0;
    }
}
