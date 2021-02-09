package com.mateuszjanczak.koronawirus.model.covid.global;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CGToday {
    private Integer newInfections;
    private Integer newDeaths;
    private List<CGDeathAgeRange> deathAgeRanges;
    private CGDeathGender deathGender;
}
