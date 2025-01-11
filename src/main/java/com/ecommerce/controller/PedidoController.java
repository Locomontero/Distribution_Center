//package com.ecommerce.controller;
//
//import com.ecommerce.model.Pedido;
//import com.ecommerce.service.IPedidoService;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/pedidos")
//public class PedidoController {
//
//    private final IPedidoService pedidoService;
//
//    public PedidoController(IPedidoService pedidoService) {
//        this.pedidoService = pedidoService;
//    }
//
//    @PostMapping
//    public Pedido processarPedido(@RequestBody Pedido pedido) {
//        return pedidoService.processarPedido(pedido);
//    }
//
//    @GetMapping("/{pedidoId}")
//    public Pedido consultarPedido(@PathVariable Long pedidoId) {
//        return pedidoService.consultarPedido(pedidoId);
//    }
//}
package com.ecommerce.controller;

import com.ecommerce.client.DistributionCenterClient;
import com.ecommerce.model.DistributionCenterResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PedidoController {

    private final DistributionCenterClient distributionCenterClient;

    public PedidoController(DistributionCenterClient distributionCenterClient) {
        this.distributionCenterClient = distributionCenterClient;
    }

    @GetMapping("/pedidos/consulta")
    public DistributionCenterResponse consultarPedido(@RequestParam String itemId) {
        return distributionCenterClient.consultarCentroDistribuicao(itemId); // Chama o cliente para consultar a API mockada
    }
}
