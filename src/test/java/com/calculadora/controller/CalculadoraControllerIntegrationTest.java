package com.calculadora.controller;

import com.calculadora.service.CalculadoraService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CalculadoraController.class)
class CalculadoraControllerIntegrationTest {


    private final MockMvc mvc;

    @Autowired
    CalculadoraControllerIntegrationTest(MockMvc mvc) {
        this.mvc = mvc;
    }

    @MockBean
    private CalculadoraService calculadoraService;

    @Test
    void DeveRequisitarASomaDeDoisNumerosERetornarCerto() throws Exception {
        //given
        String a = "5.0";
        String b = "3.0";
        String expected = "8.0";

        //when
        when(calculadoraService.somar(a, b)).thenReturn(ResponseEntity.ok(expected));
        //then
        this.mvc.perform(get("/calculadora/somar?a=" + a + "&b="+ b)).andExpect(status().isOk())
                .andExpect(content().string(containsString(expected)));
    }

    @Test
    void DeveRequisitarASomaDeUmaEntradaInvalidaoERetornarErro() throws Exception {
        //given
        String a = "foo";
        String b = "3.0";
        String expected = "Insira um valor válido";

        //when
        when(calculadoraService.somar(a, b)).thenReturn(ResponseEntity.badRequest().body(expected));
        //then
        this.mvc.perform(get("/calculadora/somar?a=" + a + "&b="+ b)).andExpect(status().isBadRequest())
                .andExpect(content().string(containsString(expected)));
    }

    @Test
    void DeveRequisitarASubtracaoDeDoisNumerosERetornarCerto() throws Exception {
        //given
        String a = "5.0";
        String b = "3.0";
        String expected ="2.0";

        //when
        when(calculadoraService.subtrair(a, b)).thenReturn(ResponseEntity.ok(expected));
        //then
        this.mvc.perform(get("/calculadora/subtrair?a=" + a + "&b="+ b)).andExpect(status().isOk())
                .andExpect(content().string(containsString(expected)));
    }

    @Test
    void DeveRequisitarASubtracaoDeUmaEntradaInvalidaoERetornarErro() throws Exception {
        //given
        String a = "foo";
        String b = "3.0";
        String expected = "Insira um valor válido";

        //when
        when(calculadoraService.subtrair(a, b)).thenReturn(ResponseEntity.badRequest().body(expected));
        //then
        this.mvc.perform(get("/calculadora/subtrair?a=" + a + "&b="+ b)).andExpect(status().isBadRequest())
                .andExpect(content().string(containsString(expected)));
    }

    @Test
    void DeveRequisitarAMultiplicacaoDeDoisNumerosERetornarCerto() throws Exception {
        //given
        String a = "5.0";
        String b = "3.0";
        String expected ="15.0";

        //when
        when(calculadoraService.multiplicar(a, b)).thenReturn(ResponseEntity.ok(expected));
        //then
        this.mvc.perform(get("/calculadora/multiplicar?a=" + a + "&b="+ b)).andExpect(status().isOk())
                .andExpect(content().string(containsString(expected)));
    }

    @Test
    void DeveRequisitarAMultiplicacaoDeUmaEntradaInvalidaoERetornarErro() throws Exception {
        //given
        String a = "foo";
        String b = "3.0";
        String expected = "Insira um valor válido";

        //when
        when(calculadoraService.multiplicar(a, b)).thenReturn(ResponseEntity.badRequest().body(expected));
        //then
        this.mvc.perform(get("/calculadora/multiplicar?a=" + a + "&b="+ b)).andExpect(status().isBadRequest())
                .andExpect(content().string(containsString(expected)));
    }

    @Test
    void DeveRequisitarADivisaoDeDoisNumerosERetornarCerto() throws Exception {
        //given
        String a = "15.0";
        String b = "3.0";
        String expected ="5.0";

        //when
        when(calculadoraService.dividir(a, b)).thenReturn(ResponseEntity.ok(expected));
        //then
        this.mvc.perform(get("/calculadora/dividir?a=" + a + "&b="+ b)).andExpect(status().isOk())
                .andExpect(content().string(containsString(expected)));
    }

    @Test
    void DeveRequisitarADivisaoDeUmaEntradaInvalidaoERetornarErro() throws Exception {
        //given
        String a = "foo";
        String b = "3.0";
        String expected = "Insira um valor válido";

        //when
        when(calculadoraService.dividir(a, b)).thenReturn(ResponseEntity.badRequest().body(expected));
        //then
        this.mvc.perform(get("/calculadora/dividir?a=" + a + "&b="+ b)).andExpect(status().isBadRequest())
                .andExpect(content().string(containsString(expected)));
    }

}