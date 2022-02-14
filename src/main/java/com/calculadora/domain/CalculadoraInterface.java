package com.calculadora.domain;

public interface CalculadoraInterface {
    Double somar(Double a, Double b);
    Double subtrair(Double a, Double b);
    Double multiplicar(Double a, Double b);
    Double dividir(Double a, Double b);

    void setResultado(Double result);
    Double getResultado();
}
