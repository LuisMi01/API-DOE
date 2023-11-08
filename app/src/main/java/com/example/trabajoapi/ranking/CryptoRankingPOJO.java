package com.example.trabajoapi.ranking;

import androidx.annotation.NonNull;

import java.util.List;

public class CryptoRankingPOJO {

    private Item coins;

    public CryptoRankingPOJO(Item coins) {
        this.coins = coins;
    }

    public Item getCoins() {
        return coins;
    }
}