package com.spring.car_dealership_IS.servicees;

import com.spring.car_dealership_IS.domain.SimpleEntityWithImg;
import com.spring.car_dealership_IS.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@Slf4j
public class ImgServiceImpl implements ImgService {


    public ImgServiceImpl(MongoRepository<SimpleEntityWithImg, String> dao) {
        this.dao = dao;
    }

    private final MongoRepository<SimpleEntityWithImg, String> dao;


    @Override
    public void saveImg(String id, MultipartFile file) {
        try {
            if (file == null) throw new NullPointerException("file is empty");

            SimpleEntityWithImg entity = dao.findById(id).orElseThrow(NotFoundException::new);

            Byte[] byteObjects = new Byte[file.getBytes().length];

            int i = 0;

            for (byte b : file.getBytes()) {
                byteObjects[i++] = b;
            }

            entity.setImg(byteObjects);

            dao.save(entity);
        } catch (IOException e) {
            log.error("Error occurred", e);
            e.printStackTrace();
        } catch (NullPointerException e) {
            log.error(e.toString());
        }
    }
}
