package com.postech.logistica.controller;

import com.postech.logistica.dto.AtualizaStatusEntregaDTO;
import com.postech.logistica.entity.Entrega;
import com.postech.logistica.enums.StatusEntrega;
import com.postech.logistica.service.EntregaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EntregaControllerTest {

    @Mock
    private EntregaService entregaService;

    @InjectMocks
    private EntregaController entregaController;

    @Test
    void deveAtualizarStatusEntrega() {
        AtualizaStatusEntregaDTO dto = new AtualizaStatusEntregaDTO(StatusEntrega.EM_ROTA);

        Entrega entrega = new Entrega();
        entrega.setId(1L);
        entrega.setStatus(StatusEntrega.EM_ROTA);

        when(entregaService.atualizarStatus(1L, StatusEntrega.EM_ROTA)).thenReturn(entrega);

        ResponseEntity<Entrega> response = entregaController.atualizarStatus(1L, dto);

        assertEquals(200, response.getStatusCode().value());
        assertEquals(StatusEntrega.EM_ROTA, response.getBody().getStatus());

        verify(entregaService, times(1)).atualizarStatus(1L, StatusEntrega.EM_ROTA);
    }
}
