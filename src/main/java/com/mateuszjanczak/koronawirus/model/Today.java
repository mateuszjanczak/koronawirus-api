package com.mateuszjanczak.koronawirus.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Today {
    private int newInfections;
    private int newDeaths;
    private List<DeathAgeRange> deathAgeRange;
    private DeathGender deathGender;
}
