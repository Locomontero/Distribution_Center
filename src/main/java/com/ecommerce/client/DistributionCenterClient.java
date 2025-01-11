package com.ecommerce.client;

import org.springframework.web.client.RestTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import com.ecommerce.model.DistributionCenterResponse;

@Component
@RequiredArgsConstructor
public class DistributionCenterClient {

    private final RestTemplate restTemplate;

    public DistributionCenterResponse requestDistributionCenter(String itemId) {
        String url = "http://localhost:8080/distribuitioncenters?itemId=" + itemId;
        return restTemplate.getForObject(url, DistributionCenterResponse.class);
    }
}
