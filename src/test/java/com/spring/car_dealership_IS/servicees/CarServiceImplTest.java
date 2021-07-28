package com.spring.car_dealership_IS.servicees;

import com.spring.car_dealership_IS.domain.Car;
import com.spring.car_dealership_IS.domain.dao.CarDao;
import com.spring.car_dealership_IS.exceptions.NotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CarServiceImplTest {

    @Mock
    private CarDao carDao;

    @InjectMocks
    private CarServiceImpl carService;

    @Test
    @DisplayName("Should successfully save car object")
    void createTest() {
        //given
        String id= "TestId";
        String name = "TestName";

        Car car = new Car();
        car.setId(id);
        car.setName(name);

        ArgumentCaptor<Car> argumentCaptor = ArgumentCaptor.forClass(Car.class);

        //when
        carService.create(car);

        //then
        verify(carDao, times(1)).save(argumentCaptor.capture());
        Car savedCar  = argumentCaptor.getValue();
        assertEquals(savedCar.getId(), id);
        assertEquals(savedCar.getName(), name);
    }

    @Test
    @DisplayName("Should return car by id")
    void findCarById() {
        //given
        String id= "TestId";

        Car car = new Car();
        car.setId(id);

        Optional<Car> optionalCar= Optional.of(car);


        when(carDao.findById(any())).thenReturn(optionalCar);

        //when
        Car foundCar = carService.findCarById(id);

        //then
        verify(carDao, times(1)).findById(anyString());
        assertEquals(car.getId(), foundCar.getId());
    }

    @Test
    @DisplayName("Should delete all data in database")
    void deleteAll() {

        verify(carDao, times(1)).deleteAll();
        verify(carDao, never()).delete(any());
        verify(carDao, never()).findById(any());
    }

    @Test
    @DisplayName("Should change car name but save old ID")
    void update() {
        //given
        String id= "OriginalId";
        String changedId = "ChangedId";

        String originalName="OriginalName";
        String changedName = "ChangedName";

        Car originalCar = new Car();
        originalCar.setId(id);
        originalCar.setName(originalName);

        Car newCar = new Car();
        newCar.setId(changedId);
        newCar.setName(changedName);

        ArgumentCaptor<Car> argumentCaptor = ArgumentCaptor.forClass(Car.class);

        //when

        carService.update(newCar, originalCar);

        //then
        verify(carDao, times(1)).save(argumentCaptor.capture());
        Car savedCar = argumentCaptor.getValue();
        assertNotEquals(newCar.getId(), savedCar.getId());
        assertEquals(savedCar.getName(), originalCar.getName());

    }

    @Test
    @DisplayName("Should delete car by id")
    void delete() {
        //given
        String id = "IdToDelete";

        when(carDao.existsById(id)).thenReturn(true);

        //when
        carService.delete(id);


        //then
        verify(carDao, times(1)).deleteById(id);
    }

    @Test

    @DisplayName("Should return 404 Exception")
    void findCarByIdNotFound(){
        Optional<Car> optionalCar = Optional.empty();

        when(carDao.findById(anyString())).thenReturn(optionalCar);

        assertThrows(NotFoundException.class, () -> carService.findCarById("id"));
    }
}