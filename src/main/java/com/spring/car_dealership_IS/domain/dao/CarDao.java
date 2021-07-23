package com.spring.car_dealership_IS.domain.dao;

import com.spring.car_dealership_IS.domain.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarDao extends MongoRepository<Car, String> {

}
