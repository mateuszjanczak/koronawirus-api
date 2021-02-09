package com.mateuszjanczak.koronawirus.model.voivodeship;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeathType {
    private Integer covid;
    private Integer comorbidities;
}
