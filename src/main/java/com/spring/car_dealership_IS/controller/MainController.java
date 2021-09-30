package com.spring.car_dealership_IS.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class MainController {

    @GetMapping("health")
    public ResponseEntity<?> getHealth (){
        return ResponseEntity.ok().build();
    }

    @GetMapping("version")
    public ResponseEntity<?> getVersion() {
        return ResponseEntity.ok("Version is 1.0 alpha)");

    }

    @GetMapping("metrics")
    public ResponseEntity<?> getMetrics(){
        return ResponseEntity.ok().build();
    }
}
