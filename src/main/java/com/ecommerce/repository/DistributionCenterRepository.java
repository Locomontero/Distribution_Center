package com.ecommerce.repository;

import com.ecommerce.model.DistributionCenter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistributionCenterRepository extends JpaRepository<DistributionCenter, Long> {
    List<DistributionCenter> findByOrders_Items_ItemName(String itemName);
}
