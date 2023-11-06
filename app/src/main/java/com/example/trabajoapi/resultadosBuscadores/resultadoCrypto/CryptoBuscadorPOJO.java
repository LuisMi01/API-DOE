package com.example.trabajoapi.resultadosBuscadores.resultadoCrypto;

public class CryptoBuscadorPOJO {
    private String name;
    private String genesisDate;
    private String description;
    private double currentPrice;
    private String homepageUrl;
    private String imageUrl;

    public CryptoBuscadorPOJO(String name, String genesisDate, String description, double currentPrice, String homepageUrl, String imageUrl) {
        this.name = name;
        this.genesisDate = genesisDate;
        this.description = description;
        this.currentPrice = currentPrice;
        this.homepageUrl = homepageUrl;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenesisDate() {
        return genesisDate;
    }

    public void setGenesisDate(String genesisDate) {
        this.genesisDate = genesisDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getHomepageUrl() {
        return homepageUrl;
    }

    public void setHomepageUrl(String homepageUrl) {
        this.homepageUrl = homepageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
