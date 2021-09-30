package com.spring.car_dealership_IS.servicees;

import com.spring.car_dealership_IS.domain.BaseModelWithImg;
import com.spring.car_dealership_IS.domain.dao.BaseModelDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@Slf4j
public class ImgServiceImpl implements ImgService {



    private final BaseModelDao dao;

    public ImgServiceImpl(BaseModelDao dao) {
        this.dao = dao;
    }


    @Override
    public void saveImg(String id, MultipartFile file) {
        try {
            if (file == null) throw new NullPointerException("file is empty");

            BaseModelWithImg entity = dao.findById(id).orElse( null);

            Byte[] byteObjects = new Byte[file.getBytes().length];

            int i = 0;

            for (byte b : file.getBytes()) {
                byteObjects[i++] = b;
            }

            assert entity != null;
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
