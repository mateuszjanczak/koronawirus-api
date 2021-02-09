package com.mateuszjanczak.koronawirus.model.vaccinations.province;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class VPReport {
    private String province;
    private Date reportDate;
    private VPGeneral general;
    private VPToday today;
}
