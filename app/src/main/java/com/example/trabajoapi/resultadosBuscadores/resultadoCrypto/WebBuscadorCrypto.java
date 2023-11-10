package com.example.trabajoapi.resultadosBuscadores.resultadoCrypto;

import java.util.List;

public class WebBuscadorCrypto {
    private final List<String> homepage;

    public WebBuscadorCrypto(List<String> homepage) {
        this.homepage = homepage;
    }

    public List<String> getHomepage() {
        return homepage;
    }
}
