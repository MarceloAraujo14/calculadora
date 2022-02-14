package com.calculadora.controller;

import com.calculadora.service.CalculadoraService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CalculadoraControllerTest {

    @Mock
    private CalculadoraService calculadoraService;

    @InjectMocks
    private CalculadoraController calculadoraController;

    @Test
    void DeveSomarDoisNumerosERetornarCerto(){
        //given
        String a = "5.0";
        String b = "3.0";
        String expected = "8.0";
        //when
        when(calculadoraService.somar(a, b)).thenReturn(ResponseEntity.ok(expected));
        ResponseEntity result = calculadoraController.somar(a, b);
        //then
        assertThat(result).isEqualTo(ResponseEntity.ok(expected));
        verify(calculadoraService).somar(a,b);
    }

    @Test
    void DeveSomarDoisNumerosComVirgulaERetornarCerto(){
        //given
        String a = "5,0";
        String b = "3,0";
        String expected = "8.0";
        //when
        when(calculadoraService.somar(a, b)).thenReturn(ResponseEntity.ok(expected));
        ResponseEntity result = calculadoraController.somar(a, b);
        //then
        assertThat(result).isEqualTo(ResponseEntity.ok(expected));
        verify(calculadoraService).somar(a,b);
    }

}