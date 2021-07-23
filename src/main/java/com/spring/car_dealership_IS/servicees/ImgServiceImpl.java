package com.spring.car_dealership_IS.servicees;

import com.spring.car_dealership_IS.domain.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Service
@Slf4j
public class ImgServiceImpl implements ImgService {

    @Autowired
    CarService carService;


    @Override
    public void saveImg(String carId, MultipartFile file) {
        try {
            Car car = carService.findCarById(carId);

            Byte[] byteObjects = new Byte[file.getBytes().length];

            int i = 0;

            for (byte b : file.getBytes()){
                byteObjects[i++] = b;
            }

            car.setCarImage(byteObjects);

            carService.create(car);
        } catch (IOException e) {
            log.error("Error occurred", e);

            e.printStackTrace();
        }
    }
}
