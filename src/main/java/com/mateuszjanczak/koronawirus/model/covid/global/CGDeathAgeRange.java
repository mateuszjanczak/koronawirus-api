package com.mateuszjanczak.koronawirus.model.covid.global;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CGDeathAgeRange {
    private CGAgeRange ageRange;
    private Integer deaths;
}
