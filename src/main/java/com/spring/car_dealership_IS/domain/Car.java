package com.spring.car_dealership_IS.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;


@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car extends BaseModelWithImg {

    private String engine;
    private String gear;
    private Integer racing;
    private String YearOfIssue;
    @DBRef
    private Mark mark;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return Objects.equals(engine, car.engine) &&
                Objects.equals(gear, car.gear) &&
                Objects.equals(racing, car.racing) &&
                Objects.equals(YearOfIssue, car.YearOfIssue) &&
                Objects.equals(mark, car.mark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), engine, gear, racing, YearOfIssue, mark);
    }
}
