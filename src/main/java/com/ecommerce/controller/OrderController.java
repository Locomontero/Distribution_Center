package com.ecommerce.controller;

import com.ecommerce.model.Order;
import com.ecommerce.service.OrderService;
import com.ecommerce.service.DistributionCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private DistributionCenterService distributionCenterService;

    @PostMapping("/process")
    public Order processOrder(@RequestBody Order order) {
        Optional.ofNullable(order.getItemName())
                .filter(itemNames -> !itemNames.isEmpty())
                .map(itemNames -> itemNames.get(0).getItemName())
                .map(itemName -> distributionCenterService.findByItemNameInOrders(itemName))
                .filter(distributionCenters -> !distributionCenters.isEmpty())
                .map(distributionCenters -> distributionCenters.get(0))
                .ifPresent(order::setDistributionCenter);

        return orderService.processOrder(order);
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }
}
