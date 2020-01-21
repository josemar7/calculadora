package com.ejercicio.calculadora.utils;

public enum Operacion {

    SUMA("+"),
    RESTA("-");
    // TODO: 21/01/2020 Aniadir mas operaciones 

    private String oper;

    Operacion(String oper) {
        this.oper = oper;
    }

    public String getOper() {
        return oper;
    }
}
