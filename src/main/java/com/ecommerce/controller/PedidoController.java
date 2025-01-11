package com.ecommerce.controller;

import com.ecommerce.model.Pedido;
import com.ecommerce.service.IPedidoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final IPedidoService pedidoService;

    public PedidoController(IPedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public Pedido processarPedido(@RequestBody Pedido pedido) {
        return pedidoService.processarPedido(pedido);
    }

    @GetMapping("/{pedidoId}")
    public Pedido consultarPedido(@PathVariable Long pedidoId) {
        return pedidoService.consultarPedido(pedidoId);
    }
}
