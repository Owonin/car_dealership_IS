package com.spring.car_dealership_IS.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
public class User {
    @Id
    private String id;
    private String name;
}
