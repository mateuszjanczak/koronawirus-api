package com.mateuszjanczak.koronawirus.model.covid;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeathAgeRange {
    private AgeRange ageRange;
    private Integer deaths;
}
