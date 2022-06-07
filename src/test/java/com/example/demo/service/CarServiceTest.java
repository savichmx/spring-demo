package com.example.demo.service;

import java.util.Arrays;
import java.util.Optional;

import com.example.demo.entity.Car;
import com.example.demo.repository.CarRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static com.example.demo.service.CarService.BRANDS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class CarServiceTest {

    private CarService carService;
    private CarRepository carRepository;

    @BeforeEach
    void init() {
        carRepository = Mockito.mock(CarRepository.class);
        carService = new CarService(carRepository);
    }

    @Test
    void shouldReturnCardFromRepositoryWhenCalGetById() {
        Integer id = 5;
        Car car = new Car();
        when(carRepository.findById(anyInt())).thenReturn(Optional.of(car));

        Car result = carService.getById(id);

        assertThat(result).isEqualTo(car);
    }

    @Test
    void shouldThrowRuntimeExceptionWhenCallGetByIdIfNoResultsWereFound() {
        Integer id = 5;
        when(carRepository.findById(anyInt())).thenReturn(Optional.empty());

        Assertions.assertThrows(RuntimeException.class, () -> carService.getById(id));
    }

    @Test
    void shouldCreateRandomCarWhenCallGenerateRandomCarMethod() {
        when(carRepository.save(any(Car.class))).thenAnswer(invocation -> invocation.getArguments()[0]);

        Car car = carService.generateRandomCar();

        assertThat(BRANDS).contains(car.getBrand());
        assertThat(car.getModel()).isNotBlank();
        assertThat(car.getYearOfProduction()).isNotNull();
        assertThat(car.getYearOfProduction()).isPositive();
    }

}