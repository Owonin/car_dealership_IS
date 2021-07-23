package com.spring.car_dealership_IS.domain.dao;

import com.spring.car_dealership_IS.domain.Mark;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MarkDao extends MongoRepository<Mark,String> {
}
