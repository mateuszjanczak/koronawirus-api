package com.mateuszjanczak.koronawirus.model.covid;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeathGender {
    private Integer male;
    private Integer female;
}
