package com.ejercicio.calculadora.web.controller;

import com.ejercicio.calculadora.service.CalculadoraService;
import com.ejercicio.calculadora.utils.Operacion;
import com.ejercicio.calculadora.utils.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CalculadoraController.class)
class CalculadoraControllerTest {

    @MockBean
    CalculadoraService calculadoraService;

    @Autowired
    MockMvc mockMvc;


    @BeforeEach
    void setUp() {
    }

    @Test
    public void suma() throws Exception {
        final BigDecimal op1 = new BigDecimal(5);
        final BigDecimal op2 = new BigDecimal(4);
        final BigDecimal resultado = new BigDecimal(9);

        given(calculadoraService.suma(op1,op2)).willReturn(resultado);
        mockMvc.perform(get("/api/v1/calculadora/suma/" + op1 + "/" + op2).accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string(StringUtils.toString(op1, op2, resultado, Operacion.SUMA)));
    }

    @Test
    public void resta() throws Exception {
        final BigDecimal op1 = new BigDecimal(10);
        final BigDecimal op2 = new BigDecimal(5);
        final BigDecimal resultado = new BigDecimal(5);

        given(calculadoraService.resta(op1,op2)).willReturn(resultado);
        mockMvc.perform(get("/api/v1/calculadora/resta/" + op1 + "/" + op2).accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string(StringUtils.toString(op1, op2, resultado, Operacion.RESTA)));
    }

}