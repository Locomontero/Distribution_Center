package com.ecommerce.controller;

import com.ecommerce.client.DistributionCenterClient;
import com.ecommerce.model.DistributionCenterResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final DistributionCenterClient distributionCenterClient;

    public OrderController(DistributionCenterClient distributionCenterClient) {
        this.distributionCenterClient = distributionCenterClient;
    }

    @GetMapping("/request/search")
    public DistributionCenterResponse requestOrder(@RequestParam String itemId) {
        return distributionCenterClient.requestDistributionCenter(itemId);
    }
}
