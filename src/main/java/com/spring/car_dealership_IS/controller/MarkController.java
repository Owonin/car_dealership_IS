package com.spring.car_dealership_IS.controller;

import com.spring.car_dealership_IS.domain.Mark;
import com.spring.car_dealership_IS.servicees.ImgService;
import com.spring.car_dealership_IS.servicees.MarkService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/marks")
@AllArgsConstructor
public class MarkController {
    private final MarkService markService;
    private final ImgService imgService;

    @GetMapping
    public ResponseEntity<List<Mark>> showAllMarks() {
        List<Mark> marks= markService.findAllMarks();
        return (marks==null)?  ResponseEntity.ok(new ArrayList<Mark>())
                : ResponseEntity.ok(marks);
    }

    @GetMapping("/{markId}")
    public ResponseEntity<?> showFirst(@PathVariable("markId") String id) {
        return ResponseEntity.ok(markService.findMarkById(id));
    }

    @PostMapping("/{mark}")
    public ResponseEntity<?> create(@RequestBody Mark mark,
                       @RequestParam(value = "img" ,required = false) MultipartFile img) {
        markService.create(mark);
        imgService.saveImg(mark.getId(),img);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{markId}")
    public ResponseEntity<?> update(@PathVariable("markId") Mark markFromDb,
                       @RequestBody Mark mark,
                       @RequestParam(value = "img", required = false) MultipartFile img){

        markService.update(mark, markFromDb);
        imgService.saveImg(mark.getId(), img);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{markId}")
    public ResponseEntity<?> delete(@PathVariable("markId") String markId){
        markService.delete(markId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
