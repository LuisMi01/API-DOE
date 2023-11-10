package com.example.trabajoapi.resultadosBuscadores.resultadosExchange;

public class ExchangeBuscadorPOJO {
    private final String name;
    private final String year_stablished;
    private final String country;
    private final String url;
    private final String image;
    private final String description;

    public ExchangeBuscadorPOJO(String name, String year_stablished, String country, String url, String image, String description) {
        this.name = name;
        this.year_stablished = year_stablished;
        this.country = country;
        this.url = url;
        this.image = image;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getYear_stablished() {
        return year_stablished;
    }

    public String getCountry() {
        return country;
    }

    public String getUrl() {
        return url;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }
}
