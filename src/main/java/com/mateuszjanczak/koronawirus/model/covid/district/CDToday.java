package com.mateuszjanczak.koronawirus.model.covid.district;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CDToday {
    private Integer infections;
    private Double infectionRatioPer10kPopulation;
    private Integer recovered;
    private CDDeath deaths;
    private CDTest tests;
}
