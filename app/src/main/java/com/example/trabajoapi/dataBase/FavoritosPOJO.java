package com.example.trabajoapi.dataBase;

public class FavoritosPOJO {
    private String name;
    private String price;
    private String image;

    public FavoritosPOJO(String name, String price, String image) {
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }
}
