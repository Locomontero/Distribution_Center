package com.ecommerce.service.impl;

import com.ecommerce.model.Order;
import com.ecommerce.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
class OrderServiceImplTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderServiceImpl orderServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testProcessOrder() {
        Order order = new Order();
        order.setClientName("Cliente Teste");
        order.setDescription("Pedido de Teste");

        when(orderRepository.save(order)).thenReturn(order);

        Order result = orderServiceImpl.processOrder(order);

        assertNotNull(result);
        assertEquals("Cliente Teste", result.getClientName());
        assertEquals("Pedido de Teste", result.getDescription());
    }

    @Test
    void testRequestOrder() {
        Long orderId = 1L;
        Order order = new Order();
        order.setId(orderId);
        order.setClientName("Cliente Teste");

        when(orderRepository.findById(orderId)).thenReturn(java.util.Optional.of(order));

        Order result = orderServiceImpl.requestOrder(orderId);

        assertNotNull(result);
        assertEquals(orderId, result.getId());
        assertEquals("Cliente Teste", result.getClientName());
    }

    @Test
    void testNonFindableRequestOrders() {
        Long orderId = 2L;

        when(orderRepository.findById(orderId)).thenReturn(java.util.Optional.empty());

        Order result = orderServiceImpl.requestOrder(orderId);

        assertNull(result);
    }
}
