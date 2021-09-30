package com.spring.car_dealership_IS.servicees;

import com.spring.car_dealership_IS.domain.Car;

import java.util.List;

public interface CarService {
    boolean create(Car car);

    Car findCarById(String id);

    void deleteAll();

    boolean update(Car car, Car carFromDb);

    boolean delete(String id);

    List<Car> findAllCars(long limit, long offset);
}
