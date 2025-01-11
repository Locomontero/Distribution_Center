package com.ecommerce.service.impl;

import com.ecommerce.client.DistributionCenterClient;
import com.ecommerce.model.DistributionCenterResponse;
import com.ecommerce.service.IDistributionCenterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DistributionCenterService implements IDistributionCenterService {

    private final DistributionCenterClient client;

    @Override
    public DistributionCenterResponse consultarCentroDistribuicao(String itemId) {
        return client.consultarCentroDistribuicao(itemId);
    }
}
