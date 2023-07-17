package com.ceiba.biblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.ceiba.biblioteca.application"})
@EnableJpaRepositories("com.ceiba.biblioteca.repositorio.sql")
@EntityScan("com.ceiba.biblioteca.repositorio")
@ComponentScan(basePackages= {"com.ceiba.biblioteca.application"})
public class BibliotecaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BibliotecaApplication.class, args);
    }
}
