package com.postech.logistica.service;

import com.google.gson.Gson;
import com.postech.logistica.dto.LogradouroDTO;
import com.postech.logistica.dto.MapApiResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriUtils;

import java.nio.charset.StandardCharsets;

@Service
public class CepService {

    private static final Logger log = LoggerFactory.getLogger(CepService.class);

    @Value("${logistica.api.maps.google-api-key}")
    private String GOOGLE_API_KEY;

    private static final String VIACEP_API_URL = "https://viacep.com.br/ws/%s/json/";
    private static final String GOOGLEMAPS_API_URL = "https://maps.googleapis.com/maps/api/geocode/json?address=%s&key=%s&sensor=true";


    public double[] buscarLatitudeLongitude(String cep) {
        try {
            var latitudeLongitude = fetchLatitudeLongitude(cep);
            return latitudeLongitude;
        } catch (Exception e) {
            System.err.println("Erro ao buscar coordenadas para o CEP " + cep + ": " + e.getMessage());
            return new double[]{0.0, 0.0};
        }
    }

    private double[] fetchLatitudeLongitude(String cep) {
        var logradouro = fetchLogradouro(cep);

        logradouro = logradouro.replaceAll(" ", "+");

        var logradouroComCep = String.format("%s,+%s",logradouro, cep);
        var encodedKey = UriUtils.encodeQuery(GOOGLE_API_KEY, StandardCharsets.UTF_8);

        log.debug("Bucando Latitude e Longitude da API: {}", GOOGLEMAPS_API_URL);
        String url = String.format(GOOGLEMAPS_API_URL, logradouroComCep, encodedKey);
        var restTemplate = new RestTemplate();

        var response = restTemplate.getForObject(url, MapApiResponseDTO.class);
        log.info("BUSCOU DO GOOGLE: \n{}",response);

        if (response != null) {
            var results = response.results();
            if (results != null && !results.isEmpty()) {
                var geometry = results.get(0).geometry();
                if (geometry != null) {
                    var location = geometry.location();
                    if (location != null) {
                        return new double[] {location.lat(), location.lng()};
                    }
                }
            }
        }

        return new double[] {};
    }

    private String fetchLogradouro(String cep) {
        log.debug("Bucando Logradouro da API: {}", VIACEP_API_URL);
        String url = String.format(VIACEP_API_URL, cep);
        RestTemplate restTemplate = new RestTemplate();
        var response = restTemplate.getForObject(url, String.class);

        var gson = new Gson();
        var logradouroDTO = gson.fromJson(response, LogradouroDTO.class);

        return logradouroDTO.logradouro();
    }
}
