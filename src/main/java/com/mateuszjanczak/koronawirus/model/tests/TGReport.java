package com.mateuszjanczak.koronawirus.model.tests;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class TGReport {
    private Date reportDate;
    private TGGeneral general;
    private TGToday today;
}
