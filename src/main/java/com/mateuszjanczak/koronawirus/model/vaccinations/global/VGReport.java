package com.mateuszjanczak.koronawirus.model.vaccinations.global;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class VGReport {
    private Date reportDate;
    private VGGeneral general;
    private VGToday today;
}
