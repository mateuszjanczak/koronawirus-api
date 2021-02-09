package com.mateuszjanczak.koronawirus.model.covid;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class General {
    private Integer infections;
    private Integer deaths;
    private Integer recovered;
}
