package com.spring.car_dealership_IS.domain.dao;

import com.spring.car_dealership_IS.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDao extends MongoRepository<User,String> {
}
