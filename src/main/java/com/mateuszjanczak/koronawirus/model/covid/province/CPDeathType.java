package com.mateuszjanczak.koronawirus.model.covid.province;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CPDeathType {
    private Integer covid;
    private Integer comorbidities;
}
