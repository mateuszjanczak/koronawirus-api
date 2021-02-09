package com.mateuszjanczak.koronawirus.model.voivodeship;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class General {
    private Integer population;
    private Integer infections;
    private Double infectionRatioPer10kPopulation;
    private Integer deaths;
    private Integer recovered;
    private Integer quarantine;
}
