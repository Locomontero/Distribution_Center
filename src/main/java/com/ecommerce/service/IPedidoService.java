package com.ecommerce.service;

import com.ecommerce.model.Pedido;

public interface IPedidoService {
    Pedido processarPedido(Pedido pedido);
    Pedido consultarPedido(Long pedidoId);
}
