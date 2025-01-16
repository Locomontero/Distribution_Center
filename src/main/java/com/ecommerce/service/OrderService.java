package com.ecommerce.service;

import com.ecommerce.model.Order;
import com.ecommerce.model.OrderItem;
import com.ecommerce.model.DistributionCenter;
import com.ecommerce.dto.OrderDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    public Order toOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setId(orderDTO.getId());

        DistributionCenter distributionCenter = new DistributionCenter(orderDTO.getDistributionCenterId());
        order.setDistributionCenter(distributionCenter);

        List<OrderItem> itemName = orderDTO.getItemName();
        order.setItemName(itemName);

        return order;
    }

    public OrderDTO toOrderDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());

        if (order.getDistributionCenter() != null) {
            orderDTO.setDistributionCenterId(order.getDistributionCenter().getId());
        }

        orderDTO.setItemName(order.getItemName());

        return orderDTO;
    }

    public Order processOrder(Order order) {
        return order;
    }

    public Order getOrderById(Long id) {
        return new Order();
    }
}
