package com.ecommerce.service;

import com.ecommerce.exception.CustomException;
import com.ecommerce.model.Order;
import com.ecommerce.model.OrderItem;
import com.ecommerce.model.DistributionCenter;
import com.ecommerce.dto.OrderDTO;
import com.ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private DistributionCenterService distributionCenterService;

    @Autowired
    private OrderRepository orderRepository;

    public Order toOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setId(orderDTO.getId());

        DistributionCenter distributionCenter = distributionCenterService.findById(orderDTO.getDistributionCenterId());
        if (distributionCenter == null) {
            throw new CustomException(404, "Distribution Center not found with ID: " + orderDTO.getDistributionCenterId());
        }
        order.setDistributionCenter(distributionCenter);

        List<OrderItem> items = orderDTO.getItems().stream()
                .map(itemDTO -> {
                    OrderItem orderItem = new OrderItem();
                    orderItem.setItemName(itemDTO.getItemName());
                    orderItem.setQuantity(itemDTO.getQuantity());
                    orderItem.setDistributionCenter(distributionCenter);
                    orderItem.setOrder(order);
                    return orderItem;
                })
                .collect(Collectors.toList());

        order.setItems(items);
        return order;
    }

    public Order processOrder(OrderDTO orderDTO) {
        Order order = toOrder(orderDTO);

        long totalItems = order.getItems().stream()
                .mapToLong(OrderItem::getQuantity)
                .sum();

        if (totalItems > 100) {
            throw new CustomException(400, "Orders can not have more than 100 items.");
        }

        return orderRepository.save(order);
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new CustomException(404, "Order not found with ID: " + id));
    }
}
