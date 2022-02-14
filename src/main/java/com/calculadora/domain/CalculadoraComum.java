package com.calculadora.domain;

import com.calculadora.exception.DivisionByZeroException;
import org.springframework.stereotype.Component;

@Component
public class CalculadoraComum implements CalculadoraInterface {

    private Double resultado = 0d;

    private Double memoria;


    @Override
    public Double somar(Double a, Double b) {
        Double calculo = a + b;
        this.setResultado(calculo);
        return calculo;
    }

    @Override
    public Double subtrair(Double a, Double b) {
        Double calculo = a - b;
        this.setResultado(calculo);
        return calculo;

    }

    @Override
    public Double multiplicar(Double a, Double b) {
        Double calculo = a * b;
        this.setResultado(calculo);
        return calculo;
    }

    @Override
    public Double dividir(Double a, Double b) {
        Double calculo = a / b;
        this.setResultado(calculo);
        return calculo;
    }

    @Override
    public void setResultado(Double result) {
        this.resultado = result;
    }

    @Override
    public Double getResultado() {
        return this.resultado;
    }
}
