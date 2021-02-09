package com.mateuszjanczak.koronawirus.model.covid.province;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CPGeneral {
    private Integer population;
    private Integer infections;
    private Double infectionRatioPer10kPopulation;
    private Integer deaths;
    private Integer recovered;
    private Integer quarantine;
}
