package com.spring.car_dealership_IS.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;


@Document
@AllArgsConstructor
@NoArgsConstructor
public class Mark extends BaseModelWithImg {
    private String CountryName;

    public String getCountryName() {
        return CountryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mark)) return false;
        if (!super.equals(o)) return false;
        Mark mark = (Mark) o;
        return Objects.equals(CountryName, mark.CountryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), CountryName);
    }

    public void setCountryName(String countryName) {
        CountryName = countryName;
    }
}
