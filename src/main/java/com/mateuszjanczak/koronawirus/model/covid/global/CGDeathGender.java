package com.mateuszjanczak.koronawirus.model.covid.global;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CGDeathGender {
    private Integer male;
    private Integer female;
}
