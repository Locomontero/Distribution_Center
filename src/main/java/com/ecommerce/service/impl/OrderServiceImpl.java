package com.ecommerce.service.impl;

import com.ecommerce.model.Order;
import com.ecommerce.repository.OrderRepository;
import com.ecommerce.service.IOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements IOrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order processOrder(Order order) {
        logger.info("Processando pedido: {}", order);
        Order savedOrder = orderRepository.save(order);
        logger.info("Pedido processado e salvo com sucesso: {}", savedOrder);
        return savedOrder;
    }

    @Override
    public Order requestOrder(Long orderId) {
        logger.info("Consultando pedido com ID: {}", orderId);
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order == null) {
            logger.warn("Pedido não encontrado para o ID: {}", orderId);
        } else {
            logger.info("Pedido encontrado: {}", order);
        }
        return order;
    }
}
