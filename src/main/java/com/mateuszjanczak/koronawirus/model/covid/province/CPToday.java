package com.mateuszjanczak.koronawirus.model.covid.province;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CPToday {
    private Integer infections;
    private Integer deaths;
    private CPTest test;
    private CPDeathType deathType;
}
