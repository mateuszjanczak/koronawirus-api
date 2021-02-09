package com.mateuszjanczak.koronawirus.model.covid.global;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CGGeneral {
    private Integer infections;
    private Integer deaths;
    private Integer recovered;
}
