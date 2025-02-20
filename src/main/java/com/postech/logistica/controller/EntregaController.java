package com.postech.logistica.controller;


import com.postech.logistica.dto.AtualizaStatusEntregaDTO;
import com.postech.logistica.entity.Entrega;
import com.postech.logistica.enums.StatusEntrega;
import com.postech.logistica.messaging.EntregaConcluidaProducer;
import com.postech.logistica.service.EntregaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

    private final EntregaService entregaService;
    
    private final EntregaConcluidaProducer entregaConcluidaProducer;

    public EntregaController(EntregaService entregaService, EntregaConcluidaProducer entregaConcluidaProducer) {
        this.entregaService = entregaService;
        this.entregaConcluidaProducer = entregaConcluidaProducer;
    }

    @GetMapping
    public List<Entrega> listarEntregas() {
        return entregaService.listarEntregas();
    }

    /**
     * Busca entregas próximas a uma localização dentro de um raio específico.
     */
    @GetMapping("/proximas")
    public List<Entrega> buscarEntregasProximas(
            @RequestParam double latitude,
            @RequestParam double longitude,
            @RequestParam(defaultValue = "10") double raioKm) {
        return entregaService.buscarEntregasProximas(latitude, longitude, raioKm);
    }
    
    @PutMapping("/{entregaId}/status")
    public ResponseEntity<Entrega> atualizarStatus(@PathVariable Long entregaId, @RequestBody AtualizaStatusEntregaDTO dto) {
        var novoStatus = dto.status();
        Entrega entregaAtualizada = entregaService.atualizarStatus(entregaId, novoStatus);
        if (StatusEntrega.ENTREGA_CONCLUIDA.equals(novoStatus)) {
            entregaConcluidaProducer.enviarEventoEntregaConcluida(entregaAtualizada.getPedidoId());
        }
        return ResponseEntity.ok(entregaAtualizada);
    }
    
    @PostMapping("/{entregaId}/concluir")
    public ResponseEntity<Void> concluirEntrega(@PathVariable Long entregaId) {
        var entregaAtualizada = entregaService.atualizarStatus(entregaId, StatusEntrega.ENTREGA_CONCLUIDA);
        entregaConcluidaProducer.enviarEventoEntregaConcluida(entregaAtualizada.getPedidoId());
        return ResponseEntity.ok().build();
    }
}

