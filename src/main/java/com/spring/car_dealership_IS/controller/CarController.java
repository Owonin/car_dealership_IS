package com.spring.car_dealership_IS.controller;

import com.spring.car_dealership_IS.domain.Car;
import com.spring.car_dealership_IS.servicees.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/")
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping("cars")
    public List<Car> index(@RequestParam(value = "limit", defaultValue = "100") Long limit) {
        return carService.findAllCars()
                .stream()
                .limit(limit)
                .collect(Collectors.toList());
    }

    @GetMapping("cars/{carId}")
    public Car showFirst(@PathVariable("carId") String id) {
        return carService
                .findCarById(id);
    }

    @PostMapping("cars")
    public void create(@RequestBody Car car) {
        carService.create(car);
    }

    @PutMapping("cars/{carId}")
    public void update(@PathVariable("carId") Car carFromDb,
                       @RequestBody Car car){
        carService.update(car, carFromDb);

    }

    @DeleteMapping("cars/{carId}")
    public void delete(@PathVariable("carId") Car car){
        carService.delete(car);
    }

}
