package com.spring.car_dealership_IS.servicees;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface ImgService {
    void saveImg(String carId, MultipartFile file);
}
