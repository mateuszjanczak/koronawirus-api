package com.mateuszjanczak.koronawirus.model.voivodeship;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class VoivodeshipReport {
    private String voivodeship;
    private Date reportDate;
    private General general;
    private Today today;
}
