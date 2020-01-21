package com.ejercicio.calculadora.web.controller;

import com.ejercicio.calculadora.constant.Constantes;
import com.ejercicio.calculadora.service.CalculadoraService;
import com.ejercicio.calculadora.utils.Operacion;
import com.ejercicio.calculadora.utils.StringUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Digits;
import java.math.BigDecimal;

@RequestMapping(Constantes.API_V_1_CALCULADORA)
@RestController
@Validated
public class CalculadoraController {

    private final CalculadoraService calculadoraService;

    public CalculadoraController(CalculadoraService calculadoraService) {
        this.calculadoraService = calculadoraService;
    }

    @GetMapping({Constantes.SUMA + "{op1}/{op2}"})
    @ApiOperation("Suma dos números pasados mediante parámetros")
    public String suma(
            @ApiParam(value = "Operando 1", required = true) @PathVariable("op1") @Digits(integer = 10,fraction = 5) final BigDecimal op1,
            @ApiParam(value = "Operando 2", required = true) @PathVariable("op2") @Digits(integer = 10,fraction = 5) final BigDecimal op2) {
        final BigDecimal resultado = calculadoraService.suma(op1, op2);
        return StringUtils.toString(op1, op2, resultado, Operacion.SUMA);
    }

    @GetMapping({Constantes.RESTA + "{op1}/{op2}"})
    @ApiOperation("Resta dos números pasados mediante parámetros")
    public String resta(
            @ApiParam(value = "Operando 1", required = true) @PathVariable("op1") @Digits(integer = 10,fraction = 5) final BigDecimal op1,
            @ApiParam(value = "Operando 1", required = true) @PathVariable("op2") @Digits(integer = 10,fraction = 5) final BigDecimal op2) {
        final BigDecimal resultado = calculadoraService.resta(op1, op2);
        return StringUtils.toString(op1, op2, resultado, Operacion.RESTA);
    }

}
