package com.calculadora.service;

import com.calculadora.domain.CalculadoraComum;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.verify;

//@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CalculadoraServiceTest {

    @Mock
    private CalculadoraComum calculadoraComum;

    @InjectMocks
    private CalculadoraService calculadoraService;

    @AfterEach
    void tearDown() {
        calculadoraComum.setResultado(0d);
    }

    @ParameterizedTest
    @CsvSource({"5.0,3.0,8.0", "-5.0,3.0,-2.0", "-5.0,-3.0,-8.0"})
    void DeveSomarDoisNumeros(String a, String b, Double expected) {
        //when
        Mockito.when(calculadoraComum.somar(Double.parseDouble(a), Double.parseDouble(b))).thenReturn(expected);
        Mockito.when(calculadoraComum.getResultado()).thenReturn(expected);
        ResponseEntity result = calculadoraService.somar(a, b);

        //then
        assertThat(result).isEqualTo(ResponseEntity.ok(expected.toString()));
        verify(calculadoraComum).somar(Double.parseDouble(a), Double.parseDouble(b));
    }

    @Test
    void DeveSomarDoisNumerosComVirgula() {
        //given
        String a = "5,0";
        String b = "3,0";
        Double expected = 8.0;
        //when
        Mockito.when(calculadoraComum.somar(5.0, 3.0)).thenReturn(expected);
        Mockito.when(calculadoraComum.getResultado()).thenReturn(expected);
        ResponseEntity result = calculadoraService.somar(a, b);

        //then
        assertThat(result).isEqualTo(ResponseEntity.ok(expected.toString()));
        verify(calculadoraComum).somar(5.0, 3.0);
    }

    @ParameterizedTest
    @CsvSource({"5.0,1.0,4.0", "-5.0,-1.0,-4.0", "-5.0,1.0,-6.0"})
    void DeveSubtrairDoisNumeros(String a, String b, Double expected) {
        //when
        Mockito.when(calculadoraComum.subtrair(Double.parseDouble(a), Double.parseDouble(b))).thenReturn(expected);
        Mockito.when(calculadoraComum.getResultado()).thenReturn(expected);
        ResponseEntity result = calculadoraService.subtrair(a, b);

        //then
        assertThat(result).isEqualTo(ResponseEntity.ok(expected.toString()));
        verify(calculadoraComum).subtrair(Double.parseDouble(a), Double.parseDouble(b));
    }



    @ParameterizedTest
    @CsvSource({"5.0,3.0,15.0", "-5.0,3.0,-15.0", "-4.0,-3.0,12.0"})
    void MultiplicaDoisNumeros(String a, String b, Double expected) {
        //when
        Mockito.when(calculadoraComum.multiplicar(Double.parseDouble(a), Double.parseDouble(b))).thenReturn(expected);
        Mockito.when(calculadoraComum.getResultado()).thenReturn(expected);
        ResponseEntity result = calculadoraService.multiplicar(a, b);

        //then
        assertThat(result).isEqualTo(ResponseEntity.ok(expected.toString()));
        verify(calculadoraComum).multiplicar(Double.parseDouble(a), Double.parseDouble(b));
    }

    @ParameterizedTest
    @CsvSource({"9.0,3.0,3.0", "-9.0,-3.0,3.0", "-9.0,3.0,-3.0"})
    void DeveDividirDoisNumeros(String a, String b, Double expected) {
        //when
        Mockito.when(calculadoraComum.dividir(Double.parseDouble(a), Double.parseDouble(b))).thenReturn(expected);
        Mockito.when(calculadoraComum.getResultado()).thenReturn(expected);
        ResponseEntity result = calculadoraService.dividir(a,b);

        //then
        assertThat(result).isEqualTo(ResponseEntity.ok(expected.toString()));
        verify(calculadoraComum).dividir(Double.parseDouble(a), Double.parseDouble(b));
    }

    @Test
    void DeveFalharQuandoAlgumForNulo(){
        //given
        String a = null;
        String b = "3.0";
        //when
        //then
        assertThatThrownBy(() -> calculadoraService.somar(a, b))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("Valor não informado.");
    }

    @Test
    void DeveFalharQuandoAlgumForBranco(){
        //given
        String a = "5.0";
        String b = "";
        //when
        //then
        assertThatThrownBy(() -> calculadoraService.somar(a, b))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("Valor não informado.");
    }

    @Test
    void DeveSubtrairDoisNumerosComVirgula() {
        //given
        String a = "5,0";
        String b = "3,0";
        Double expected = 2.0;
        //when
        Mockito.when(calculadoraComum.subtrair(5.0, 3.0)).thenReturn(expected);
        Mockito.when(calculadoraComum.getResultado()).thenReturn(expected);
        ResponseEntity result = calculadoraService.subtrair(a, b);

        //then
        assertThat(result).isEqualTo(ResponseEntity.ok(expected.toString()));
        verify(calculadoraComum).subtrair(5.0, 3.0);
    }

    @Test
    void DeveMultiplicarDoisNumerosComVirgula() {
        //given
        String a = "5,0";
        String b = "3,0";
        Double expected = 15.0;
        //when
        Mockito.when(calculadoraComum.multiplicar(5.0, 3.0)).thenReturn(expected);
        Mockito.when(calculadoraComum.getResultado()).thenReturn(expected);
        ResponseEntity result = calculadoraService.multiplicar(a, b);

        //then
        assertThat(result).isEqualTo(ResponseEntity.ok(expected.toString()));
        verify(calculadoraComum).multiplicar(5.0, 3.0);
    }

    @Test
    void DeveDividirDoisNumerosComVirgula() {
        //given
        String a = "15,0";
        String b = "3,0";
        Double expected = 5.0;
        //when
        Mockito.when(calculadoraComum.dividir(15.0, 3.0)).thenReturn(expected);
        Mockito.when(calculadoraComum.getResultado()).thenReturn(expected);
        ResponseEntity result = calculadoraService.dividir(a, b);

        //then
        assertThat(result).isEqualTo(ResponseEntity.ok(expected.toString()));
        verify(calculadoraComum).dividir(15.0, 3.0);
    }

}