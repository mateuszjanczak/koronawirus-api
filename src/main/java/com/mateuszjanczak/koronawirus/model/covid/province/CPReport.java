package com.mateuszjanczak.koronawirus.model.covid.province;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class CPReport {
    private String province;
    private Date reportDate;
    private CPGeneral general;
    private CPToday today;
}
