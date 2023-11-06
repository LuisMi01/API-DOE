package com.example.trabajoapi.resultadosBuscadores.resultadoCrypto;

public class ValorMercadoCrypto {
    private CurrentPrice current_price;

    public ValorMercadoCrypto(CurrentPrice current_price) {
        this.current_price = current_price;
    }

    public CurrentPrice getCurrent_price() {
        return current_price;
    }
}
