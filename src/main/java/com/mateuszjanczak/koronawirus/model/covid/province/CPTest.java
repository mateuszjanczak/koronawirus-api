package com.mateuszjanczak.koronawirus.model.covid.province;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CPTest {
    private Integer all;
    private Integer positive;
    private Integer negative;
    private Integer poz;
    private Integer other;
}
