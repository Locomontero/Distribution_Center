package com.ecommerce.service;

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

        DistributionCenter distributionCenter = new DistributionCenter(orderDTO.getDistributionCenterId());
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
            throw new IllegalArgumentException("O pedido não pode conter mais de 100 itens.");
        }

        return orderRepository.save(order);
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }
}
