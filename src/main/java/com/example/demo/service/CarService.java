package com.example.demo.service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import com.example.demo.entity.Car;
import com.example.demo.repository.CarRepository;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    public static final List<String> BRANDS = Arrays.asList("Audi", "Toyota", "Tesla", "Opel", "BMW", "Ferrari");
    private final Random random = new Random();

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car generateRandomCar() {
        Car car = new Car();
        car.setBrand(BRANDS.get(random.nextInt(BRANDS.size())));
        car.setModel(UUID.randomUUID().toString());
        car.setYearOfProduction(random.nextInt(2022));

        return carRepository.save(car);
    }

    public Car getById(Integer id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No car with id " + id + " was found!"));
    }

    public List<Car> getAllByBrand(String brand) {
        return carRepository.findByBrand(brand);
    }

    public List<Car> findCarsWithYear(Integer year) {
        return carRepository.findCardWithYearLessThan(year);
    }


}
