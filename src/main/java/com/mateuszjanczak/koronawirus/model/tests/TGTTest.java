package com.mateuszjanczak.koronawirus.model.tests;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TGTTest {
    private Integer all;
    private Integer positive;
    private Integer poz;
}
