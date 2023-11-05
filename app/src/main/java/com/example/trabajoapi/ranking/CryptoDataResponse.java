package com.example.trabajoapi.ranking;

import java.util.List;

public class CryptoDataResponse {
    private final List<CryptoRankingPOJO> coins;

    public CryptoDataResponse(List<CryptoRankingPOJO> coins) {
        this.coins = coins;
    }

    public List<CryptoRankingPOJO> getCoins() {
        return coins;
    }
}
