package com.spring.car_dealership_IS.servicees;

import com.spring.car_dealership_IS.domain.Car;
import com.spring.car_dealership_IS.domain.dao.CarDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ImgServiceImplTest {

    @Mock
    private CarDao carDao;

    @InjectMocks
    private ImgServiceImpl imgService;

    @Test
    @DisplayName("Should correctly save image")
    void saveImgTest() throws IOException {
        String id = "1";
        byte[] arr = new byte[] {1,1,1};

        MultipartFile multipartFile = new MockMultipartFile("img", "testing.txt",
                "text/plain", "Image".getBytes());
        Car car = new Car();
        car.setId(id);
        Optional<Car>  optionalCar= Optional.of(car);

        when(carDao.findById(any())).thenReturn(optionalCar);
        ArgumentCaptor<Car> argumentCaptor = ArgumentCaptor.forClass(Car.class);

        //when
        imgService.saveImg(id,multipartFile);

        //then
        verify(carDao, times(1)).findById(any());
        verify(carDao, times(1)).save(argumentCaptor.capture());
        Car savedCar = argumentCaptor.getValue();
        assertEquals(savedCar.getImg().length, multipartFile.getBytes().length);
    }

    @Test
    @DisplayName("Should write error info in the log")
    void EmptyFileTest() throws IOException {
        String id = "1";

        Car car = new Car();
        car.setId(id);

        //when
        imgService.saveImg(id,null);

        //then
        verify(carDao, never()).findById(any());
        verify(carDao, never()).save(any());
    }
}