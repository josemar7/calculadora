package com.ejercicio.calculadora.service.impl;

import com.ejercicio.calculadora.exception.CalculadoraException;
import com.ejercicio.calculadora.service.CalculadoraService;
import com.ejercicio.calculadora.utils.Operacion;
import com.ejercicio.calculadora.utils.StringUtils;
import com.ejercicio.calculadora.web.model.ResultadoOperacion;
import io.corp.calculator.TracerImpl;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculadoraServiceImpl implements CalculadoraService {

    private final TracerImpl tracer = new TracerImpl();

    @Override
    public ResultadoOperacion suma(final BigDecimal op1, final BigDecimal op2) {
        return realizarOperacion(op1, op2, Operacion.SUMA);
    }

    @Override
    public ResultadoOperacion resta(final BigDecimal op1, final BigDecimal op2) {
        return realizarOperacion(op1, op2, Operacion.RESTA);
    }

    /**
     * calculo de operaciones
     * @param op1, operando 1
     * @param op2, operando 2
     * @param operacion, tipo de operacion
     * @return ResultadoOperacion
     */
    private ResultadoOperacion realizarOperacion(final BigDecimal op1, final BigDecimal op2, final Operacion operacion) {
        final BigDecimal resultado;
        switch (operacion) {
            case SUMA:
                resultado = op1.add(op2);
                break;
            case RESTA:
                resultado = op1.subtract(op2);
                break;
            default:
                throw new CalculadoraException("Operacion no soportada");
        }
        tracer.trace(StringUtils.toString(op1, op2, resultado, operacion));
        return ResultadoOperacion.builder()
                .operando1(op1).operando2(op2).operacion(operacion.getOper()).resultado(resultado)
                .build();
    }
}
