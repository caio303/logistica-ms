package com.postech.logistica.messaging.messages;

public class StatusEntregaEvento {
    private Long pedidoId;
    private int novoStatusId;

    public StatusEntregaEvento(Long pedidoId, int novoStatusId) {
        this.pedidoId = pedidoId;
        this.novoStatusId = novoStatusId;
    }

    public StatusEntregaEvento() {
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public int getNovoStatusId() {
        return novoStatusId;
    }

    public void setNovoStatusId(int novoStatusId) {
        this.novoStatusId = novoStatusId;
    }
}
