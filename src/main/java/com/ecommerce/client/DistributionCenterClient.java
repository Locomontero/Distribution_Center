package com.ecommerce.client;

import com.ecommerce.model.DistributionCenter;
import com.ecommerce.model.DistributionCenterResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Component
public class DistributionCenterClient {

    private final RestTemplate restTemplate;

    public DistributionCenterClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<DistributionCenter> requestDistributionCenter(List<String> itemNames) {
        String url = "http://localhost:8080/distributioncenters?itemNames=" + String.join(",", itemNames);
        DistributionCenterResponse response = restTemplate.getForObject(url, DistributionCenterResponse.class);
        return response != null ? response.getDistributionCenters() : List.of();
    }

    public DistributionCenter requestDistributionCenterById(Long distributionCenterId) {
        String url = "http://localhost:8080/distributioncenters/" + distributionCenterId;
        return restTemplate.getForObject(url, DistributionCenter.class);
    }
}
