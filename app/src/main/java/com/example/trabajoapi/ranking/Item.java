package com.example.trabajoapi.ranking;

public class Item {

    private String name;
    private int score;
    private double price;

    private String small;

    public Item(String name, int score, double price, String small) {
        this.name = name;
        this.score = score;
        this.price = price;
        this.small = small;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public double getPrice() {
        return price;
    }

    public String getSmall() {
        return small;
    }
}
