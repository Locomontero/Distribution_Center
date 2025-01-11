package com.ecommerce.service;

import com.ecommerce.model.DistributionCenterResponse;

public interface IDistributionCenterService {

    DistributionCenterResponse consultarCentroDistribuicao(String itemId);
}
