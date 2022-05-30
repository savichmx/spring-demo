package com.example.demo.controller;

import java.util.List;

import com.example.demo.entity.Car;
import com.example.demo.service.CalculationService;
import com.example.demo.service.CarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

    private final CalculationService calculationService;
    private final CarService carService;

    public DemoController(CalculationService calculationService, CarService carService) {
        this.calculationService = calculationService;
        this.carService = carService;
    }

    @GetMapping("/sum")
    public int calculateSum(Integer a, Integer b) {
        return calculationService.sum(a, b);
    }

    @GetMapping("/generate-car")
    public Car generateCar() {
        return carService.generateRandomCar();
    }

    @GetMapping("/cars/{id}")
    public Car generateCar(@PathVariable Integer id) {
        return carService.getById(id);
    }

    @GetMapping("/cars/brands/{brand}")
    public List<Car> generateCar(@PathVariable String brand) {
        return carService.getAllByBrand(brand);
    }

    @GetMapping("/cars")
    public List<Car> findCarWithYear(Integer yearOfBirth) {
        return carService.findCarsWithYear(yearOfBirth);
    }


}
