package com.mateuszjanczak.koronawirus.model.voivodeship;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Test {
    private Integer all;
    private Integer positive;
    private Integer negative;
    private Integer poz;
    private Integer other;
}
