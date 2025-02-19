package com.postech.logistica.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Logistica Service",
                version = "0.0.1-mvp",
                description = "Logistica Service MVP - Tech Challenge Fase 4",
                contact = @Contact(
                        name = "Grupo 14 - 5ADJT"
                )
        )
)
public interface DocumentedApi {
}
