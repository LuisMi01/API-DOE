package com.example.trabajoapi.ranking;

import androidx.annotation.NonNull;

import java.util.List;

public class CryptoRankingPOJO {
    private String name;
    private int score;
    private double price;

    private String image;
    private boolean favorito;

    public CryptoRankingPOJO(String name, int score, double price, String image, boolean favorito) {
        this.name = name;
        this.score = score;
        this.price = price;
        this.image = image;
        this.favorito = favorito;
    }
    public CryptoRankingPOJO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

  /*  private List<CryptoRankingPOJO> coins;

    public List<CryptoRankingPOJO> getCoins() {
        return coins;
    }

    public void setCoins(List<CryptoRankingPOJO> coins) {
        this.coins = coins;
    }*/
}