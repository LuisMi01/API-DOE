package com.example.trabajoapi.ranking;

public class Item {

    private String name;
    private int score;
    private double price_btc;

    private String small;

    public Item(String name, int score, double price_btc, String small) {
        this.name = name;
        this.score = score;
        this.price_btc = price_btc;
        this.small = small;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score + 1;
    }

    public double getPrice_btc() {
        return price_btc;
    }

    public String getSmall() {
        return small;
    }
}
