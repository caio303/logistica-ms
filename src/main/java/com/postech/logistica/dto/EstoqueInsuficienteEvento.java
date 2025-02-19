package com.postech.logistica.dto;

public class EstoqueInsuficienteEvento {
    private Long pedidoId;
    private boolean estoqueSuficiente;

    public EstoqueInsuficienteEvento(Long pedidoId, boolean estoqueSuficiente) {
        this.pedidoId = pedidoId;
        this.estoqueSuficiente = estoqueSuficiente;
    }

    public EstoqueInsuficienteEvento() {
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public boolean isEstoqueSuficiente() {
        return estoqueSuficiente;
    }

    public void setEstoqueSuficiente(boolean estoqueSuficiente) {
        this.estoqueSuficiente = estoqueSuficiente;
    }
}
