package com.ejercicio.calculadora.web.controller;

import com.ejercicio.calculadora.service.CalculadoraService;
import com.ejercicio.calculadora.utils.Operacion;
import com.ejercicio.calculadora.utils.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RequestMapping("/api/v1/calculadora")
@RestController
@Validated
public class CalculadoraController {

    private final CalculadoraService calculadoraService;

    public CalculadoraController(CalculadoraService calculadoraService) {
        this.calculadoraService = calculadoraService;
    }

    @GetMapping({"/suma/{op1}/{op2}"})
    public String suma(@PathVariable("op1") final BigDecimal op1, @PathVariable("op2") final BigDecimal op2) {
        final BigDecimal resultado = calculadoraService.suma(op1, op2);
        return StringUtils.toString(op1, op2, resultado, Operacion.SUMA);
    }

    @GetMapping({"/resta/{op1}/{op2}"})
    public String resta(@PathVariable("op1") final BigDecimal op1, @PathVariable("op2") final BigDecimal op2) {
        final BigDecimal resultado = calculadoraService.resta(op1, op2);
        return StringUtils.toString(op1, op2, resultado, Operacion.RESTA);
    }

}
