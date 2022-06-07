package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.entity.Car;
import com.example.demo.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static com.example.demo.service.CarService.BRANDS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoControllerRealDatabaseIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String host;

    @BeforeEach
    void init() {
        host = "http://localhost:" + port;
    }

    @Test
    void shouldCallGetSumEndpointWithCorrectParameters() {
        Map<String, Integer> params = new HashMap<>();
        params.put("a", 4);
        params.put("b", 3);
        Integer result = this.restTemplate.getForObject(host + "/demo/sum?a={a}&b={b}", Integer.class, params);

        assertThat(result).isEqualTo(7);
    }

    @Test
    void shouldGenerateRandomCar() throws InterruptedException {
        Car result = this.restTemplate.getForObject(host + "/demo/generate-car", Car.class);

        assertThat(BRANDS).contains(result.getBrand());
        assertThat(result.getModel()).isNotBlank();
        assertThat(result.getYearOfProduction()).isNotNull();
        assertThat(result.getYearOfProduction()).isPositive();
    }

}