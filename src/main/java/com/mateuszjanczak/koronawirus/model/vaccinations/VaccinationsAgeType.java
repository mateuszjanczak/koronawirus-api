package com.mateuszjanczak.koronawirus.model.vaccinations;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VaccinationsAgeType {
    private AgeType ageType;
    private Integer vaccinations;
}
