package com.mateuszjanczak.koronawirus.model.covid.district;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CDTest {
    private Integer all;
    private Integer positive;
    private Integer negative;
    private Integer poz;
    private Integer other;
}
