package com.mateuszjanczak.koronawirus.model.tests;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TGTDeath {
    private Integer deaths;
    private Integer covid;
    private Integer coexistent;
}
