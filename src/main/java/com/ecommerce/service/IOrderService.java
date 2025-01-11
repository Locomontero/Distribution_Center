package com.ecommerce.service;

import com.ecommerce.model.Order;

public interface IOrderService {
    Order processOrder(Order order);
    Order requestOrder(Long orderId);
}
