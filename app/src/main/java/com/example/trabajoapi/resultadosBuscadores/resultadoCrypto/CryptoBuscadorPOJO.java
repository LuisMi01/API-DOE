package com.example.trabajoapi.resultadosBuscadores.resultadoCrypto;

public class CryptoBuscadorPOJO {
    private String name;
    private String image;
    private String genesis_date;
    private String current_price;
    private String homepage;
    private String description;

    public CryptoBuscadorPOJO(String name, String image, String genesis_date, String current_price, String homepage, String description) {
        this.name = name;
        this.image = image;
        this.genesis_date = genesis_date;
        this.current_price = current_price;
        this.homepage = homepage;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGenesis_date() {
        return genesis_date;
    }

    public void setGenesis_date(String genesis_date) {
        this.genesis_date = genesis_date;
    }

    public String getCurrent_price() {
        return current_price;
    }

    public void setCurrent_price(String current_price) {
        this.current_price = current_price;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CryptoBuscadorPOJO() {
    }
}
