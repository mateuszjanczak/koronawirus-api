package com.mateuszjanczak.koronawirus.model.vaccinations.province;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VPToday {
    private Integer vaccinations;
    private Integer firstDoses;
    private Integer secondDoses;
}
