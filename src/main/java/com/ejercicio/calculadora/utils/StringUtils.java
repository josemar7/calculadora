package com.ejercicio.calculadora.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class StringUtils {

    private StringUtils() {}

    private static final DecimalFormat df = new DecimalFormat("#,###.00000");

    /**
     * formatea a String la operacion con sus operandos y resultado
     * @param op1, operando 1
     * @param op2, operando 2
     * @param resultado, resultado de la operacion
     * @param operacion, tipo de operacion (suma o resta)
     * @return String
     */
    public static String toString(BigDecimal op1, BigDecimal op2, BigDecimal resultado, Operacion operacion) {
        return String.format("%s %s %s = %s", df.format(op1), operacion.getOper(), df.format(op2), df.format(resultado));
    }

}
