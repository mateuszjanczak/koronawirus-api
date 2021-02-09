package com.mateuszjanczak.koronawirus.model.vaccinations.province;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VPGeneral {
    private Integer population;
    private Integer vaccinations;
    private Integer firstDoses;
    private Integer secondDoses;
}
