package com.spring.car_dealership_IS.controller;

import com.spring.car_dealership_IS.domain.User;
import com.spring.car_dealership_IS.domain.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MainController {

    @Autowired
    UserDao userDao;

    @GetMapping("/")
    public List<Map<String, String>> index() {
        return new ArrayList<>() {
            {
                add(new HashMap<>() {{
                    put("a", "a");
                }});
            }
        };
    }

    @GetMapping("/{id}")
    public User showFirst(@PathVariable("id")String id) {
        User user = userDao.findById(id).orElse(new User("1", "Mat"));
        return user;
    }

    @PostMapping("/")
    public Map<String, String> create(@RequestBody Map<String, String> param) {
        return new HashMap<>();
    }
}
