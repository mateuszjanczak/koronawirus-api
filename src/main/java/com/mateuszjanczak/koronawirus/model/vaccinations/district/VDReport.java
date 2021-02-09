package com.mateuszjanczak.koronawirus.model.vaccinations.district;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class VDReport {
    private String district;
    private Date reportDate;
    private VDGeneral general;
    private VDToday today;
}
