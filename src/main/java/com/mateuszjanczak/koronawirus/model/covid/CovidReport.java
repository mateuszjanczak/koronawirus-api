package com.mateuszjanczak.koronawirus.model.covid;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class CovidReport {
    private Date reportDate;
    private General general;
    private Today today;
}

