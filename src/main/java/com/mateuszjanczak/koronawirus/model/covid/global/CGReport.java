package com.mateuszjanczak.koronawirus.model.covid.global;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class CGReport {
    private Date reportDate;
    private CGGeneral general;
    private CGToday today;
}

