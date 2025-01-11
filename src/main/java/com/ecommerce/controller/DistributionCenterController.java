package com.ecommerce.controller;

import com.ecommerce.model.DistributionCenterResponse;
import com.ecommerce.service.IDistributionCenterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DistributionCenterController {

    private final IDistributionCenterService service;

    public DistributionCenterController(IDistributionCenterService service) {
        this.service = service;
    }

    @GetMapping("/distributioncenters")
    public DistributionCenterResponse consultarCentroDistribuicao(@RequestParam String itemId) {
        return service.consultarCentroDistribuicao(itemId);
    }
}
