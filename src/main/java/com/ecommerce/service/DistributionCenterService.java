package com.ecommerce.service;

import com.ecommerce.exception.CustomException;
import com.ecommerce.model.DistributionCenter;
import com.ecommerce.repository.DistributionCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistributionCenterService {

    @Autowired
    private DistributionCenterRepository distributionCenterRepository;

    public List<DistributionCenter> findByItemNameInOrders(String itemName) {
        List<DistributionCenter> distributionCenters = distributionCenterRepository.findByOrders_Items_ItemName(itemName);

        if (distributionCenters.isEmpty()) {
            return List.of();
        }
        return distributionCenters;
    }

    public DistributionCenter findById(Long id) {
        DistributionCenter distributionCenter = distributionCenterRepository.findById(id)
                .orElseThrow(() -> new CustomException(404, "DistributionCenter not found with ID: " + id));

        // Log para depuração
        System.out.println("Distribuição encontrada: " + distributionCenter);

        return distributionCenter;
    }
}
