package com.postech.logistica.messaging.messages;

import com.postech.logistica.enums.StatusEntrega;

public class EntregaIniciadaEvento {
    private Long pedidoId;
    private StatusEntrega status;

    public EntregaIniciadaEvento(Long pedidoId, StatusEntrega status) {
        this.pedidoId = pedidoId;
        this.status = status;
    }

    public EntregaIniciadaEvento() {
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public StatusEntrega getStatus() {
        return status;
    }

    public void setStatus(StatusEntrega status) {
        this.status = status;
    }
}
