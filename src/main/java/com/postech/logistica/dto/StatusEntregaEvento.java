package com.postech.logistica.dto;

import com.postech.logistica.enums.StatusEntrega;

public class StatusEntregaEvento {
    private Long entregaId;
    private StatusEntrega status;

    public StatusEntregaEvento(Long entregaId, StatusEntrega status) {
        this.entregaId = entregaId;
        this.status = status;
    }

    public StatusEntregaEvento() {
    }

    public Long getEntregaId() {
        return entregaId;
    }

    public void setEntregaId(Long entregaId) {
        this.entregaId = entregaId;
    }

    public StatusEntrega getStatus() {
        return status;
    }

    public void setStatus(StatusEntrega status) {
        this.status = status;
    }
}
