package com.calculadora.service;

import com.calculadora.domain.CalculadoraComum;
import com.calculadora.exception.DivisionByZeroException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service("service")
public class CalculadoraService {

    @Autowired
    private CalculadoraComum calculadoraComum;

    public ResponseEntity somar(String a, String b){
        if (a == null || b == null || a.isBlank() || b.isBlank()){
            throw new NullPointerException("Valor não informado.");
        }
        try {
            if(a.contains(",")){
                a = a.replace(",", ".");
            }
            if(b.contains(",")){
                b = b.replace(",", ".");
            }
        calculadoraComum.somar(Double.parseDouble(a), Double.parseDouble(b));
        return ResponseEntity.ok(calculadoraComum.getResultado().toString());}
        catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body("Insira um valor válido");
        }
    }

    public ResponseEntity subtrair(String a, String b){
        if (a == null || b == null || a.isBlank() || b.isBlank()){
            throw new NullPointerException("Valor não informado.");
        }
        try {
            if(a.contains(",")){
                a = a.replace(",", ".");
            }
            if(b.contains(",")){
                b = b.replace(",", ".");
            }
            calculadoraComum.subtrair(Double.parseDouble(a), Double.parseDouble(b));
            return ResponseEntity.ok(calculadoraComum.getResultado().toString());}
        catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body("Insira um valor válido");
        }
    }

    public ResponseEntity multiplicar(String a, String b){
        if (a == null || b == null || a.isBlank() || b.isBlank()){
            throw new NullPointerException("Valor não informado.");
        }
        try {
            if(a.contains(",")){
                a = a.replace(",", ".");
            }
            if(b.contains(",")){
                b = b.replace(",", ".");
            }
            calculadoraComum.multiplicar(Double.parseDouble(a), Double.parseDouble(b));
            return ResponseEntity.ok(calculadoraComum.getResultado().toString());}
        catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body("Insira um valor válido");
        }
    }

    public ResponseEntity dividir(String a, String b){
        if (a == null || b == null || a.isBlank() || b.isBlank()){
            throw new NullPointerException("Valor não informado.");
        }
        try {
            if (b.equals("0.0") || b.equals("0")){
                throw new DivisionByZeroException("Não é possível dividir por zero");
            }
            if(a.contains(",")){
                a = a.replace(",", ".");
            }
            if(b.contains(",")){
                b = b.replace(",", ".");
            }
            calculadoraComum.dividir(Double.parseDouble(a), Double.parseDouble(b));
            return ResponseEntity.ok(calculadoraComum.getResultado().toString());}
        catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body("Insira um valor válido");
        } catch (DivisionByZeroException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
