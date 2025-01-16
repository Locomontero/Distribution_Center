package com.ecommerce.service;

import com.ecommerce.model.DistributionCenter;
import com.ecommerce.repository.DistributionCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistributionCenterService {

    @Autowired
    private DistributionCenterRepository distributionCenterRepository;

    public List<DistributionCenter> findByItemNameInOrders(String itemName) {
        return Optional.ofNullable(distributionCenterRepository.findByOrderItems_ItemName(itemName))
                .filter(list -> !list.isEmpty())
                .orElseGet(List::of);
    }
}
