package com.ejercicio.calculadora.web.model;

import java.math.BigDecimal;
import java.util.Objects;

public class ResultadoOperacion {

    BigDecimal operando1;
    BigDecimal operando2;
    String operacion;
    BigDecimal resultado;

    public BigDecimal getOperando1() {
        return operando1;
    }

    public void setOperando1(BigDecimal operando1) {
        this.operando1 = operando1;
    }

    public BigDecimal getOperando2() {
        return operando2;
    }

    public void setOperando2(BigDecimal operando2) {
        this.operando2 = operando2;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public BigDecimal getResultado() {
        return resultado;
    }

    public void setResultado(BigDecimal resultado) {
        this.resultado = resultado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultadoOperacion that = (ResultadoOperacion) o;
        return operando1.equals(that.operando1) &&
                operando2.equals(that.operando2) &&
                operacion.equals(that.operacion) &&
                resultado.equals(that.resultado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operando1, operando2, operacion, resultado);
    }
}
