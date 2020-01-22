package com.ejercicio.calculadora.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResultadoOperacion {

    private BigDecimal operando1;
    private BigDecimal operando2;
    private String operacion;
    private BigDecimal resultado;

}
