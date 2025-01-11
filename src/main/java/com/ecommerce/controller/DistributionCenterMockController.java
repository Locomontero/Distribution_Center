package com.ecommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.DistributionCenterResponse;


import java.util.Arrays;
import java.util.List;

@RestController
public class DistributionCenterMockController {

    @GetMapping("/distribuitioncenters")
    public DistributionCenterResponse consultarCentrosDistribuicao(@RequestParam String itemId) {
        // Simula a consulta a CDs com base no itemId
        List<String> distribuicaoCentros = Arrays.asList("CD1", "CD2", "CD3"); // Mock de CDs
        return new DistributionCenterResponse(distribuicaoCentros);
    }
}
