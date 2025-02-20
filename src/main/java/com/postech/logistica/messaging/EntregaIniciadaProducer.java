package com.postech.logistica.messaging;

import com.postech.logistica.enums.StatusEntrega;
import com.postech.logistica.messaging.messages.EntregaIniciadaEvento;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
public class EntregaIniciadaProducer {

    private final StreamBridge streamBridge;

    public EntregaIniciadaProducer(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    public void enviarEventoEntregaIniciada(Long pedidoId) {
        EntregaIniciadaEvento evento = new EntregaIniciadaEvento(pedidoId, StatusEntrega.INICIADO);
        System.out.println("Enviando evento de entrega iniciada: " + evento);
        streamBridge.send("entregaIniciadaProducer-out-0", evento);
    }
}
