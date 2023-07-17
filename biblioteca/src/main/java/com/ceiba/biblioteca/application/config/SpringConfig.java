package com.ceiba.biblioteca.application.config;

import com.ceiba.biblioteca.controlador.PrestamoControlador;
import com.ceiba.biblioteca.converter.nucleo.prestamo.servicio.PrestamoServicio;
import com.ceiba.biblioteca.repositorio.sql.PrestamoSqlRepository;
import com.ceiba.biblioteca.repositorio.sql.adaptador.PrestamoSqlAdaptador;
import com.ceiba.biblioteca.repositorio.sql.dao.PrestamoSqlDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.ceiba.biblioteca.repositorio"})
public class SpringConfig {

	@Autowired
	private PrestamoSqlDao prestamoSqlDao;

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplateBuilder().setConnectTimeout(Duration.ofMillis(1000)).build();
	}

	@Bean
	public PrestamoSqlRepository prestamoSqlRepository() {
		return new PrestamoSqlAdaptador(prestamoSqlDao);
	}

	@Bean
	public PrestamoServicio prestamoServicio() {
		return new PrestamoServicio(prestamoSqlRepository());
	}

	@Bean
	public PrestamoControlador prestamoControlador() {
		return new PrestamoControlador(prestamoServicio());
	}

}
