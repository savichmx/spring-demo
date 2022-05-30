package com.example.demo.controller;

import com.example.demo.service.CalculationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/second")
public class SecondController {

    private final CalculationService calculationService;

    public SecondController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @GetMapping("/sum")
    public int calculateSum(Integer a, Integer b) {
        return calculationService.sum(a, b);
    }

}
