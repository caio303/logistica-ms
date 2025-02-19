package com.postech.logistica;

import com.postech.logistica.config.DocumentedApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class LogisticaApplication implements DocumentedApi {

	public static void main(String[] args) {
		SpringApplication.run(LogisticaApplication.class, args);
	}

}
