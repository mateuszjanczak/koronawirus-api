package com.mateuszjanczak.koronawirus.model.tests;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TGToday {
    private Integer infections;
    private TGTDeath deaths;
    private Integer recovered;
    private TGTTest tests;
}
