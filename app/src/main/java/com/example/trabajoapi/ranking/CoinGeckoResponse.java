package com.example.trabajoapi.ranking;

import java.util.List;

public class CoinGeckoResponse {
    private List<CryptoRankingPOJO> coins;

    public List<CryptoRankingPOJO> getCoins() {
        return coins;
    }

    public void setCoins(List<CryptoRankingPOJO> coins) {
        this.coins = coins;
    }
}
