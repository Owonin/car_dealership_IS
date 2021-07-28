package com.spring.car_dealership_IS.servicees;

import com.spring.car_dealership_IS.domain.Car;
import com.spring.car_dealership_IS.domain.dao.CarDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@Slf4j
public class ImgServiceImpl implements ImgService {


    public ImgServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }

    private final CarDao carDao;


    @Override
    public void saveImg(String carId, MultipartFile file) {
        try {
            Car car = carDao.findById(carId).orElseThrow(NullPointerException::new);

            Byte[] byteObjects = new Byte[file.getBytes().length];

            int i = 0;

            for (byte b : file.getBytes()){
                byteObjects[i++] = b;
            }

            car.setCarImage(byteObjects);

            carDao.save(car);
        } catch (IOException e) {
            log.error("Error occurred", e);

            e.printStackTrace();
        }
    }
}
