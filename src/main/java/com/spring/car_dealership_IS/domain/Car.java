package com.spring.car_dealership_IS.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;



@Document
@Data
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    private String id;
    private String name;
    private String engine;
    private String gear;
    private Integer racing;
    private String YearOfIssue;
    @DBRef
    private Mark mark;
    private Byte[] carImage;
}
