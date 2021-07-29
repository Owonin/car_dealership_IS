package com.spring.car_dealership_IS.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;



@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car extends SimpleEntityWithImg {
    private String engine;
    private String gear;
    private Integer racing;
    private String YearOfIssue;
    @DBRef
    private Mark mark;
}
