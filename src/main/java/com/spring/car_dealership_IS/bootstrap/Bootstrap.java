package com.spring.car_dealership_IS.bootstrap;

import com.spring.car_dealership_IS.domain.Car;
import com.spring.car_dealership_IS.domain.Mark;
import com.spring.car_dealership_IS.domain.dao.MarkDao;
import com.spring.car_dealership_IS.servicees.CarService;
import com.spring.car_dealership_IS.servicees.ImgService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
   private CarService carService;
    @Autowired
    private MarkDao markDao;
    @Autowired
    private ImgService imgService;

    public void init(){
        markDao.deleteAll();
        carService.deleteAll();


        Mark mark = new Mark();
        mark.setId(UUID.randomUUID().toString());
        mark.setCountryName("France");
        mark.setName("Lol");

        Car car = new Car();
        car.setId("1");
        car.setEngine("Petrol");
        car.setName("Mercedes");
        car.setGear("Full");
        car.setRacing(14);
        car.setYearOfIssue("2020");
        car.setMark(mark);
        carService.create(car);
        markDao.save(mark);

        Car car2 = new Car();
        car2.setId("2");
        car2.setEngine("Petrol");
        car2.setName("BMW");
        car2.setGear("Hew");
        car2.setRacing(14);
        car2.setYearOfIssue("2020");
        carService.create(car2);

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.info("Bootstrap init");
        init();
    }
}
