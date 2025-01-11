package com.ecommerce.service;

import com.ecommerce.model.DistributionCenterResponse;

public interface IDistributionCenterService {
    DistributionCenterResponse requestDistributionCenter(String itemId);
}
