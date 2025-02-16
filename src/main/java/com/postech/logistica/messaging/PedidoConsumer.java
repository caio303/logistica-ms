package com.postech.logistica.messaging;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.postech.logistica.dto.NovoPedidoEvento;
import com.postech.logistica.service.EntregaService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PedidoConsumer {

    private final EntregaService entregaService;

    @Bean
    public Consumer<NovoPedidoEvento> novoPedidoConsumer() {
        return pedidoEvento -> {
            System.out.println("Novo pedido recebido para entrega: " + pedidoEvento);
            entregaService.criarEntrega(
                    pedidoEvento.getPedidoId(),
                    pedidoEvento.getEndereco(),
                    pedidoEvento.getLatitude(),
                    pedidoEvento.getLongitude()
            );
        };
    }
}
