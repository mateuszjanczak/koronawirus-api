package com.mateuszjanczak.koronawirus.model.covid.province;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CPToday {
    private Integer infections;
    private Double infectionRatioPer10kPopulation;
    private CPTest tests;
    private CPDeath deaths;
}
