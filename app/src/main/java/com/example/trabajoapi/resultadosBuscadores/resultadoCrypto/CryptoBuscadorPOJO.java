package com.example.trabajoapi.resultadosBuscadores.resultadoCrypto;

public class CryptoBuscadorPOJO {


    private final String name;
    private final String genesis_date;

    private DescripcionCrypto description;

    public DescripcionCrypto getDescription() {
        return description;
    }

    private ValorMercadoCrypto market_data;

    public ValorMercadoCrypto getMarket_data() {
        return market_data;
    }

    private WebBuscadorCrypto links;

    public WebBuscadorCrypto getLinks() {
        return links;
    }

    private ImagenBuscadorCrypto image;

    public ImagenBuscadorCrypto getImage() {
        return image;
    }



    public CryptoBuscadorPOJO(String name, String genesis_date) {
        this.name = name;
        this.genesis_date = genesis_date;
    }

    public String getName() {
        return name;
    }

    public String getGenesis_date() {
        return genesis_date;
    }


}
