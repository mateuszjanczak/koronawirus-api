package com.mateuszjanczak.koronawirus.model.covid.district;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CDDeath {
    private Integer deaths;
    private Integer covid;
    private Integer coexistent;
}
