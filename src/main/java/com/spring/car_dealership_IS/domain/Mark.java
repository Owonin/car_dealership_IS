package com.spring.car_dealership_IS.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Mark {
    @Id
    private String id;
    private String name;
    private String CountryName;
    private Byte[] logo;
}
