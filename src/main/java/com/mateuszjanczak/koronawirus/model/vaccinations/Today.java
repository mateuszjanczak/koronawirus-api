package com.mateuszjanczak.koronawirus.model.vaccinations;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Today {
    private Integer vaccinations;
    private Integer firstDoses;
    private Integer secondDoses;
}
