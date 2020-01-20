package com.ejercicio.calculadora.service.impl;

import com.ejercicio.calculadora.service.CalculadoraService;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraServiceImpl implements CalculadoraService {

    @Override
    public String getBeerName(String beerName) {
        return "Cerveza " + beerName;
    }

}
