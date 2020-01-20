package com.ejercicio.calculadora.web.controller;

import com.ejercicio.calculadora.service.CalculadoraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/calculadora")
@RestController
public class CalculadoraController {

    private final CalculadoraService calculadoraService;

    public CalculadoraController(CalculadoraService calculadoraService) {
        this.calculadoraService = calculadoraService;
    }

    @GetMapping("/whoami")
    public ResponseEntity<String> whoami() {
        String hostname = System.getenv().getOrDefault("HOSTNAME", "Unknown");
        return new ResponseEntity<>(String.format("Calculadora Spring Boot desde %s", hostname), HttpStatus.OK);
    }

    @GetMapping({"/{beerName}"})
    public ResponseEntity<String> getBeer(@PathVariable("beerName") String beerName) {
        return new ResponseEntity<>(calculadoraService.getBeerName(beerName), HttpStatus.OK);
    }

}
