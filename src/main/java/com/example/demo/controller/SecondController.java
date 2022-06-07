package com.example.demo.controller;

import com.example.demo.service.CalculationService;
import com.example.demo.service.TestCalss;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/second")
public class SecondController {

    private final CalculationService calculationService;
    public final TestCalss testCalss;

    public SecondController(CalculationService calculationService, TestCalss testCalss) {
        this.calculationService = calculationService;
        this.testCalss = testCalss;
    }

    @GetMapping("/sum")
    public int calculateSum(Integer a, Integer b) {
        return calculationService.sum(a, b);
    }

    @GetMapping("/test-class")
    public String testClass() {
        return testCalss.hello();
    }

}
