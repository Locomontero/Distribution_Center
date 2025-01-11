package com.ecommerce.model;

import java.util.List;

public class DistributionCenterResponse {

    private List<String> distribuicaoCentros;

    public DistributionCenterResponse(List<String> distribuicaoCentros) {
        this.distribuicaoCentros = distribuicaoCentros;
    }

    public List<String> getDistribuicaoCentros() {
        return distribuicaoCentros;
    }

    public void setDistribuicaoCentros(List<String> distribuicaoCentros) {
        this.distribuicaoCentros = distribuicaoCentros;
    }
}
