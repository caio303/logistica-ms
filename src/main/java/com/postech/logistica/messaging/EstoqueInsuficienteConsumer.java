package com.postech.logistica.messaging;

import com.postech.logistica.messaging.messages.EstoqueInsuficienteEvento;
import com.postech.logistica.service.EntregaService;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class EstoqueInsuficienteConsumer implements Consumer<EstoqueInsuficienteEvento> {

    private final EntregaService entregaService;
    private final EntregaIniciadaProducer entregaIniciadaProducer;

    public EstoqueInsuficienteConsumer(EntregaService entregaService, EntregaIniciadaProducer entregaIniciadaProducer) {
        this.entregaService = entregaService;
        this.entregaIniciadaProducer = entregaIniciadaProducer;
    }

    @Override
    public void accept(EstoqueInsuficienteEvento evento) {
        System.out.println("Verificando estoque para pedido " + evento.getPedidoId());

        if (!evento.isEstoqueSuficiente()) {
            System.out.println("Estoque insuficiente! Cancelando entrega para o pedido: " + evento.getPedidoId());
            entregaService.cancelarEntrega(evento.getPedidoId());
        } else {
            System.out.println("Estoque suficiente. Continuando entrega para o pedido: " + evento.getPedidoId());
            entregaIniciadaProducer.enviarEventoEntregaIniciada(evento.getPedidoId());
        }
    }
}
