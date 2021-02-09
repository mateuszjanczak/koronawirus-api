package com.mateuszjanczak.koronawirus.model.covid;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Today {
    private Integer newInfections;
    private Integer newDeaths;
    private List<DeathAgeRange> deathAgeRange;
    private DeathGender deathGender;
}
