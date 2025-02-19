package com.postech.logistica.service;

import com.postech.logistica.dto.LatitudeLongitudeDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CepService {

    private static final String API_URL = "https://viacep.com.br/ws/%s/json/";

    // TODO: buscar latitude e longitude, viacep não retorna esses dados
    public double[] buscarLatitudeLongitude(String cep) {
        try {
            String url = String.format(API_URL, cep);
            RestTemplate restTemplate = new RestTemplate();
            var response = restTemplate.getForObject(url, LatitudeLongitudeDTO.class);
            
            return new double[]{response.latitude(), response.longitude()};
        } catch (Exception e) {
            System.err.println("Erro ao buscar coordenadas para o CEP " + cep + ": " + e.getMessage());
            return new double[]{0.0, 0.0};
        }
    }
}
