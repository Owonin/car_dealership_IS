package com.spring.car_dealership_IS.controller;

import com.spring.car_dealership_IS.domain.Car;
import com.spring.car_dealership_IS.servicees.CarService;
import com.spring.car_dealership_IS.servicees.ImgService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CarController {

    public CarController(CarService carService, ImgService imgService) {
        this.carService = carService;
        this.imgService = imgService;
    }

    private final CarService carService;
    private final ImgService imgService;


    @GetMapping("cars")
    public List<Car> index(
            @RequestParam(value = "limit", defaultValue = "-1") Long limit,
            @RequestParam(value = "offset", defaultValue = "0") Long offset) {
        return carService.findAllCars(limit, offset);
    }

    @GetMapping("cars/{carId}")
    public Car showFirst(@PathVariable("carId") String id) {
        return carService
                .findCarById(id);
    }

    @PostMapping("cars")
    public void create(@RequestBody Car car,
                       @RequestParam(value = "img" ,required = false) MultipartFile img) {
        carService.create(car);
        imgService.saveImg(car.getId(),img);
    }

    @PutMapping("cars/{carId}")
    public void update(@PathVariable("carId") Car carFromDb,
                       @RequestBody Car car,
                       @RequestParam(value = "img", required = false) MultipartFile img){

        carService.update(car, carFromDb);
        imgService.saveImg(car.getId(), img);
    }

    @DeleteMapping("cars/{carId}")
    public void delete(@PathVariable("carId") String carId){
        carService.delete(carId);
    }

}
