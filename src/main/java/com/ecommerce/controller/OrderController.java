package com.ecommerce.controller;

import com.ecommerce.dto.OrderDTO;
import com.ecommerce.model.DistributionCenter;
import com.ecommerce.model.Order;
import com.ecommerce.service.OrderService;
import com.ecommerce.service.DistributionCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private DistributionCenterService distributionCenterService;

    @PostMapping("/process")
    public Order processOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.processOrder(orderDTO);
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/distribution-centers/items/{itemName}")
    public List<DistributionCenter> getDistributionCentersByItemName(@PathVariable String itemName) {
        return distributionCenterService.findByItemNameInOrders(itemName);
    }

    @GetMapping("/distribution-centers/{id}")
    public DistributionCenter getDistributionCenter(@PathVariable Long id) {
        return distributionCenterService.findById(id);
    }
}

