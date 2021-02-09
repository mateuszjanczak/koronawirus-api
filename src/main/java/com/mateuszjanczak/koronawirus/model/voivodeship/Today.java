package com.mateuszjanczak.koronawirus.model.voivodeship;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Today {
    private Integer infections;
    private Integer deaths;
    private Test test;
    private DeathType deathType;
}
