package com.mateuszjanczak.koronawirus.model.vaccinations.global;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VGVaccinationsAgeType {
    private VGAgeType ageType;
    private Integer vaccinations;
}
