package com.ecommerce.service.impl;

import com.ecommerce.model.Pedido;
import com.ecommerce.repository.PedidoRepository;
import com.ecommerce.service.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements IPedidoService {

    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoServiceImpl(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public Pedido processarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido consultarPedido(Long pedidoId) {
        return pedidoRepository.findById(pedidoId).orElse(null);
    }
}
