package com.calculadora.domain;

import com.calculadora.exception.DivisionByZeroException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

//@SpringBootTest
class CalculadoraComumTest {


    CalculadoraComum calculadoraComum = new CalculadoraComum();

    @AfterEach
    void tearDown() {
        calculadoraComum.setResultado(0d);
    }

    @ParameterizedTest
    @CsvSource({"5.0,3.0,8.0", "-5.0,3.0,-2.0", "-5.0,-3.0,-8.0"})
    void DeveSomarDoisNumeros(Double a, Double b, Double expected) {
        //when
        Double result = calculadoraComum.somar(a, b);

        //then
        assertThat(result).isEqualTo(expected);

    }


    @ParameterizedTest
    @CsvSource({"5.0,1.0,4.0", "-5.0,-1.0,-4.0", "-5.0,1.0,-6.0"})
    void DeveSubtrairDoisNumeros(Double a, Double b, Double expected) {
        //when
        Double result = calculadoraComum.subtrair(a, b);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"5.0,3.0,15.0", "-5.0,3.0,-15.0", "-4.0,-3.0,12.0"})
    void DeveMultiplicarDoisNumeros(Double a, Double b, Double expected) {
        //when
        Double result = calculadoraComum.multiplicar(a, b);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"9.0,3.0,3.0", "-9.0,-3.0,3.0", "-9.0,3.0,-3.0"})
    void DeveDividirDoisNumeros(Double a, Double b, Double expected) {
        //when
        Double result = calculadoraComum.dividir(a, b);

        //then
        assertThat(result).isEqualTo(expected);
    }

//    @Test
//    void DeveRetornarErroAoDividirPorZero(){
//        //given
//        Double a = 5.0;
//        Double b = 0.0;
//        //when
//        //then
//        assertThatThrownBy(() -> calculadoraComum.dividir(a, b))
//                .isInstanceOf(DivisionByZeroException.class)
//                .hasMessageContaining("Não é possível dividir por zero");
//
//    }


    @Test
    void DeveSetarResultadoEsperado() {
        //given
        Double a = 9.0;
        Double b = 3.0;
        Double soma = a + b;

        //when
        calculadoraComum.setResultado(soma);
        Double result = calculadoraComum.getResultado();
        Double expected = 12.0;

        //then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void DeveRetornarResultadoEsperado() {
        //given
        Double a = -9.0;
        Double b = 3.0;
        calculadoraComum.somar(a, b);

        //when
        Double result = calculadoraComum.getResultado();
        Double expected = -6.0;

        //then
        assertThat(result).isEqualTo(expected);
    }




    @Test
    void testConstructor() {
        CalculadoraComum actualCalculadoraComum = new CalculadoraComum();
        actualCalculadoraComum.setResultado(10.0);
        assertEquals(10.0, actualCalculadoraComum.getResultado().doubleValue());
    }

    @Test
    void testConstructor2() {
        assertEquals(0.0, (new CalculadoraComum()).getResultado().doubleValue());
    }


}