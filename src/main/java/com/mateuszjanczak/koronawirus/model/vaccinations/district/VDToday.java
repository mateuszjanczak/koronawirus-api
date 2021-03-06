package com.mateuszjanczak.koronawirus.model.vaccinations.district;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VDToday {
    private Integer vaccinations;
    private Integer firstDoses;
    private Integer secondDoses;
}
