package com.example.trabajoapi.resultadosBuscadores.resultadoNft.nftDetalle;

public class NftDetallePOJO {

    private final String name;
    private final String asset_platform_id;
    private final String symbol;
    private final String contract_address;
    private final String description;
    private final Imagen image;
    private final FloorPrice floor_price;

    public NftDetallePOJO(String name, String asset_platform_id, String symbol, String contract_address, String description, Imagen image, FloorPrice floor_price) {
        this.name = name;
        this.asset_platform_id = asset_platform_id;
        this.symbol = symbol;
        this.contract_address = contract_address;
        this.description = description;
        this.image = image;
        this.floor_price = floor_price;
    }

    public String getName() {
        return name;
    }

    public String getAsset_platform_id() {
        return asset_platform_id;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getContract_address() {
        return contract_address;
    }

    public String getDescription() {
        return description;
    }

    public Imagen getImage() {
        return image;
    }

    public FloorPrice getFloor_price() {
        return floor_price;
    }
}
