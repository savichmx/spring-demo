package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CarRepository extends CrudRepository<Car, Integer> {

    List<Car> findByBrand(String brand);

    @Query("SELECT c FROM Car c where c.yearOfProduction < :yearOfProduction")
    List<Car> findCardWithYearLessThan(@Param("yearOfProduction") Integer yearOfProduction);

}
