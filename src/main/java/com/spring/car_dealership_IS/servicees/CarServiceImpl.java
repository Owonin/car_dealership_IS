package com.spring.car_dealership_IS.servicees;

import com.spring.car_dealership_IS.domain.Car;
import com.spring.car_dealership_IS.domain.dao.CarDao;
import com.spring.car_dealership_IS.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CarServiceImpl implements CarService {

    private final CarDao carDao;

    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }


    @Override
    public boolean create(Car car) {
        carDao.save(car);
        log.info("Car with id= " + car.getId() + " has been added");
        return true;
    }

    @Override
    public Car findCarById(String id) {
        return carDao.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public void deleteAll() {
        carDao.deleteAll();
    }

    @Override
    public boolean update(Car car, Car carFromDb) {
        BeanUtils.copyProperties(car, carFromDb, "id");
        carDao.save(carFromDb);
        return false;
    }

    @Override
    public boolean delete(String id) {
        if (carDao.existsById(id)) {
            carDao.deleteById(id);
            log.info("Car with id " + id + " has been deleted");
            return true;
        }
        log.error("This car has not been found");
        return false;
    }

    @Override
    public List<Car> findAllCars() {
        return carDao.findAll();
    }
}
