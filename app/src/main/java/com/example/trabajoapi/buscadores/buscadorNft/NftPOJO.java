package com.example.trabajoapi.buscadores.buscadorNft;

public class NftPOJO {
    private String id;
    private String symbol;
    private String contract_address;
    private String asset_platform_id;

    public NftPOJO(String id, String symbol, String contract_address, String asset_platform_id) {
        this.id = id;
        this.symbol = symbol;
        this.contract_address = contract_address;
        this.asset_platform_id = asset_platform_id;
    }

    public String getNftId() {
        return id;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getContract_address() {
        return contract_address;
    }

    public String getAsset_platform_id() {
        return asset_platform_id;
    }
}
