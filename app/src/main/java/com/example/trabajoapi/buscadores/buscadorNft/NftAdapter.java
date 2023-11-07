package com.example.trabajoapi.buscadores.buscadorNft;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabajoapi.R;

import java.util.List;

public class NftAdapter extends RecyclerView.Adapter<NftViewHolder>{

    private List<NftPOJO> dataList;

    public NftAdapter(List<NftPOJO> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public NftViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_tarjeta_nft, parent, false);
        return new NftViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NftViewHolder holder, int position) {
        NftPOJO data = dataList.get(position);
        holder.textViewTitle.setText(data.getNftId());
        holder.textViewSimbolo.setText(data.getSymbol());
        holder.textViewContract.setText(data.getContract_address());
        holder.textViewPlatform.setText(data.getAsset_platform_id());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

}
