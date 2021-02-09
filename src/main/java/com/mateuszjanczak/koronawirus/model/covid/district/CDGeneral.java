package com.mateuszjanczak.koronawirus.model.covid.district;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CDGeneral {
    private Integer population;
    private Integer quarantine;
}
