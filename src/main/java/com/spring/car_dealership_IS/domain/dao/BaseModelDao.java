package com.spring.car_dealership_IS.domain.dao;

import com.spring.car_dealership_IS.domain.BaseModelWithImg;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BaseModelDao extends MongoRepository<BaseModelWithImg,String> {
}
