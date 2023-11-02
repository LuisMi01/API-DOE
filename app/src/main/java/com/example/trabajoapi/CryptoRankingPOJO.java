package com.example.trabajoapi;

public class CryptoRankingPOJO {
    private String name;
    private int score;
    private double price;
    private String image;


    public CryptoRankingPOJO(String name, int score, double price, String image) {
        this.name = name;
        this.score = score;
        this.price = price;
        this.image = image;
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


    @Override
    public String toString() {
        return "CryptoRankingPOJO{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", price=" + price +
                ", image='" + image + '\'' +
                '}';
    }
}
