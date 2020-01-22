package com.ejercicio.calculadora.web.controller;

import com.ejercicio.calculadora.constant.Constantes;
import com.ejercicio.calculadora.service.CalculadoraService;
import com.ejercicio.calculadora.utils.Operacion;
import com.ejercicio.calculadora.web.model.ResultadoOperacion;
import io.corp.calculator.TracerImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CalculadoraController.class)
class CalculadoraControllerTest {

    private static final String ACCESO_A = "Acceso a ";
    private final TracerImpl tracer = new TracerImpl();
    ResultadoOperacion resultadoOperacion;

    @MockBean
    CalculadoraService calculadoraService;

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        final BigDecimal op1 = new BigDecimal("10");
        final BigDecimal op2 = new BigDecimal("5");
        resultadoOperacion = ResultadoOperacion.builder().operando1(op1).operando2(op2).build();
    }

    @Test
    public void suma() throws Exception {
        BigDecimal resultado = new BigDecimal("15");
        resultadoOperacion.setOperacion(Operacion.SUMA.getOper());
        resultadoOperacion.setResultado(resultado);
        test(Operacion.SUMA);
    }

    @Test
    public void resta() throws Exception {
        BigDecimal resultado = new BigDecimal("5");
        resultadoOperacion.setOperacion(Operacion.RESTA.getOper());
        resultadoOperacion.setResultado(resultado);
        test(Operacion.RESTA);
    }

    private void test(final Operacion operacion) throws Exception {
        String op = operacion.equals(Operacion.SUMA) ? Constantes.SUMA : Constantes.RESTA;
        final String requestMapping = Constantes.API_V_1_CALCULADORA + op + resultadoOperacion.getOperando1() + "/" + resultadoOperacion.getOperando2();
        tracer.trace("Operandos : " + resultadoOperacion.getOperando1().toString() + " y " + resultadoOperacion.getOperando2().toString());
        tracer.trace(ACCESO_A + requestMapping);
        if (operacion.equals(Operacion.SUMA)) {
            given(calculadoraService.suma(resultadoOperacion.getOperando1(),resultadoOperacion.getOperando2())).willReturn(resultadoOperacion);
        }
        else {
            given(calculadoraService.resta(resultadoOperacion.getOperando1(),resultadoOperacion.getOperando2())).willReturn(resultadoOperacion);
        }
        mockMvc.perform(get(requestMapping).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.resultado").value(resultadoOperacion.getResultado()))
                .andExpect(jsonPath("$.operacion", is(resultadoOperacion.getOperacion())));

    }

}