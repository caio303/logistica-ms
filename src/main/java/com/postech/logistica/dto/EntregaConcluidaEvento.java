package com.postech.logistica.dto;

import com.postech.logistica.enums.StatusEntrega;

public class EntregaConcluidaEvento {
    private Long pedidoId;
    private StatusEntrega status;

    public EntregaConcluidaEvento(Long pedidoId, StatusEntrega status) {
        this.pedidoId = pedidoId;
        this.status = status;
    }

    public EntregaConcluidaEvento() {
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

