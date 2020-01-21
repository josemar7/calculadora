package com.ejercicio.calculadora.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CalculadoraServiceTest {

    @Autowired
    CalculadoraService calculadoraService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void suma() {
        BigDecimal op1 = new BigDecimal(1);
        BigDecimal op2 = new BigDecimal(2);
        BigDecimal resultado = calculadoraService.suma(op1, op2);
        assertEquals(new BigDecimal(3),resultado);
    }

    @Test
    void resta() {
        BigDecimal op1 = new BigDecimal(5);
        BigDecimal op2 = new BigDecimal(3);
        BigDecimal resultado = calculadoraService.resta(op1, op2);
        assertEquals(new BigDecimal(2),resultado);
    }
}