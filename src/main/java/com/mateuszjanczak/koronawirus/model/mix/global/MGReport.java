package com.mateuszjanczak.koronawirus.model.mix.global;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class MGReport {
    private Date reportDate;
    private MGGeneral general;
    private MGToday today;
}
