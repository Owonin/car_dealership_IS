package com.spring.car_dealership_IS.servicees;

import com.spring.car_dealership_IS.domain.Mark;
import com.spring.car_dealership_IS.domain.dao.MarkDao;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class MarkServiceImpl implements MarkService {

    private final MarkDao markDao;

    @Override
    public boolean create(Mark mark) {
        markDao.save(mark);
        log.info("Mark with " + mark.getId()+ " id has been added");
        return true;
    }

    @Override
    public Mark findMarkById(String id) {
        return markDao.findById(id).orElseThrow(NullPointerException::new);
    }

    @Override
    public List<Mark> findAllMarks() {
        return markDao.findAll();
    }

    @Override
    public void deleteAll() {
        markDao.deleteAll();
        log.info("All mark data has been deleted");
    }

    @Override
    public boolean update(Mark mark, Mark markFromDb) {
        BeanUtils.copyProperties(mark, markFromDb, "id");
        markDao.save(markFromDb);
        log.info("Mark with " + mark.getId() + " id has been updated");
        return true;
    }

    @Override
    public boolean delete(String id) {
        markDao.deleteById(id);
        log.info("Mark with " + id + " id has been deleted");
        return true;
    }
}
