package com.ejercicio.calculadora.utils;

public enum Operacion {

    SUMA("+"),
    RESTA("-");

    private String oper;

    Operacion(String oper) {
        this.oper = oper;
    }

    public String getOper() {
        return oper;
    }
}
