package com.mateuszjanczak.koronawirus.model.vaccinations.global;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VGToday {
    private Integer vaccinations;
    private Integer firstDoses;
    private Integer secondDoses;
}
