package com.mateuszjanczak.koronawirus.model.covid.province;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CPDeath {
    private Integer deaths;
    private Integer covid;
    private Integer coexistent;
}
