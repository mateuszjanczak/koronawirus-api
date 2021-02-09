package com.mateuszjanczak.koronawirus.model.vaccinations;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class VaccinationsReport {
    private Date reportDate;
    private General general;
    private Today today;
}
