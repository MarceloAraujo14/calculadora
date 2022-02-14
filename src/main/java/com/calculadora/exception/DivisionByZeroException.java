package com.calculadora.exception;

public class DivisionByZeroException extends ArithmeticException{
    public DivisionByZeroException(String errorMessage){
        super(errorMessage);
    }
}
