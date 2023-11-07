package com.example.trabajoapi.buscadores.buscadorNft;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabajoapi.R;
import com.example.trabajoapi.resultadosBuscadores.resultadoNft.nftDetalle.NftDetalle;
import com.example.trabajoapi.resultadosBuscadores.resultadosExchange.ResultadoExchange;

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
        holder.textViewTitle.setText("Nombre:\n" + data.getNftId());
        holder.textViewSimbolo.setText("Símolo:\n"+data.getSymbol());
        holder.textViewContract.setText("Direccion del contrato:\n" + data.getContract_address());
        holder.textViewPlatform.setText("Plataforma:\n" + data.getAsset_platform_id());

        holder.masDetalles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NftPOJO selectedNft = dataList.get(position);
                Intent intent = new Intent(view.getContext(), NftDetalle.class);
                intent.putExtra("nft_id", selectedNft.getNftId());
                //Intent intent = new Intent(this, ResultadoExchange.class);
                //intent.putExtra("ExchangeId", userInput);
                //startActivity(intent);
                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

}
