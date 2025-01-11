package com.ecommerce.client;

import com.ecommerce.model.DistributionCenterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class DistributionCenterClient {

    private final RestTemplate restTemplate;

    public DistributionCenterResponse consultarCentroDistribuicao(String itemId) {
        String url = "https://api.exemplo.com/distribuicao/" + itemId;  // Substitua pela URL correta da API
        return restTemplate.getForObject(url, DistributionCenterResponse.class);
    }
}
