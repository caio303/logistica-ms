package com.postech.logistica.dto;

import java.util.Map;

public record NovoPedidoDTO (
        Long pedidoId,
        String cep,
        Map<Long, Integer> itens
) {
}
