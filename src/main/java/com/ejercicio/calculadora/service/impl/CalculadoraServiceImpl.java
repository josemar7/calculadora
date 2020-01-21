package com.ejercicio.calculadora.service.impl;

import com.ejercicio.calculadora.service.CalculadoraService;
import com.ejercicio.calculadora.utils.Operacion;
import com.ejercicio.calculadora.utils.StringUtils;
import io.corp.calculator.TracerImpl;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculadoraServiceImpl implements CalculadoraService {

    private final TracerImpl tracer = new TracerImpl();

    @Override
    public BigDecimal suma(final BigDecimal op1, final BigDecimal op2) {
        final BigDecimal resultado = op1.add(op2);
        tracer.trace(StringUtils.toString(op1, op2, resultado, Operacion.SUMA));
        return resultado;
    }

    @Override
    public BigDecimal resta(BigDecimal op1, BigDecimal op2) {
        final BigDecimal resultado = op1.subtract(op2);
        tracer.trace(StringUtils.toString(op1, op2, resultado, Operacion.RESTA));
        return resultado;
    }
}
