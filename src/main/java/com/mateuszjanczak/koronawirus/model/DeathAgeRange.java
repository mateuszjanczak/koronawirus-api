package com.mateuszjanczak.koronawirus.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeathAgeRange {
    private AgeRange ageRange;
    private int deaths;
}
