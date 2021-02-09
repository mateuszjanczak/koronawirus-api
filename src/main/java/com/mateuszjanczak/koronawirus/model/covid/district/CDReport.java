package com.mateuszjanczak.koronawirus.model.covid.district;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class CDReport {
    private String district;
    private String province;
    private Date reportDate;
    private CDGeneral general;
    private CDToday today;
}
