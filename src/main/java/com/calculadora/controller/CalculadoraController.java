package com.calculadora.controller;

import com.calculadora.service.CalculadoraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

    private final CalculadoraService calculadoraService;

    public CalculadoraController(CalculadoraService calculadoraService) {
        this.calculadoraService = calculadoraService;
    }

    @GetMapping("/somar")
    public ResponseEntity somar(@RequestParam(name = "a", defaultValue = "0.0") String a, @RequestParam(name = "b", defaultValue = "0.0") String b) {
        return calculadoraService.somar(a,b);
    }

    @GetMapping("/subtrair")
    public ResponseEntity subtrair(@RequestParam(name = "a", defaultValue = "0.0") String a, @RequestParam(name = "b", defaultValue = "0.0") String b) {
        return calculadoraService.subtrair(a,b);
    }

    @GetMapping("/multiplicar")
    public ResponseEntity multiplicar(@RequestParam(name = "a", defaultValue = "0.0") String a, @RequestParam(name = "b", defaultValue = "0.0") String b) {
        return calculadoraService.multiplicar(a,b);
    }

    @GetMapping("/dividir")
    public ResponseEntity dividir(@RequestParam(name = "a", defaultValue = "0.0") String a, @RequestParam(name = "b", defaultValue = "0.0") String b) {
        return calculadoraService.dividir(a,b);
    }
}
