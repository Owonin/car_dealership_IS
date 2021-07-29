package com.spring.car_dealership_IS.servicees;

import com.spring.car_dealership_IS.domain.Car;
import com.spring.car_dealership_IS.domain.Mark;

import java.util.List;

public interface MarkService{
    boolean create(Mark mark);

    Mark findMarkById(String id);

    List<Mark> findAllMarks();

    void deleteAll();

    boolean update(Mark mark, Mark markFromDb);

    boolean delete(String id);
}
