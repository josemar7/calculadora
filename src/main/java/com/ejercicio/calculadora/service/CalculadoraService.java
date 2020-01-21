package com.ejercicio.calculadora.service;

import java.math.BigDecimal;

public interface CalculadoraService {

    /**
     * operacion suma
     * @param op1, operando 1
     * @param op2, operando 2
     */
    BigDecimal suma(final BigDecimal op1, final BigDecimal op2);

    /**
     * operacion resta
     * @param op1, operando1
     * @param op2, operando2
     */
    BigDecimal resta(BigDecimal op1, BigDecimal op2);
}
