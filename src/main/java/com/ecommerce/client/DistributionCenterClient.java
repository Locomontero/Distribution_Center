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
        String url = "http://localhost:8080/distribuitioncenters?itemId=" + itemId; // URL mockada
        return restTemplate.getForObject(url, DistributionCenterResponse.class); // Chama o mock da API
    }
}
