package com.ejercicio.calculadora.service;

import com.ejercicio.calculadora.web.model.ResultadoOperacion;

import java.math.BigDecimal;

public interface CalculadoraService {

    /**
     * operacion suma
     * @param op1, operando 1
     * @param op2, operando 2
     * @return ResultadoOperacion
     */
    ResultadoOperacion suma(final BigDecimal op1, final BigDecimal op2);

    /**
     * operacion resta
     * @param op1, operando1
     * @param op2, operando2
     * @return ResultadoOperacion
     */
    ResultadoOperacion resta(BigDecimal op1, BigDecimal op2);
}
