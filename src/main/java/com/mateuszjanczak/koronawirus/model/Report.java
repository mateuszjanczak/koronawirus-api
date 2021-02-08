package com.mateuszjanczak.koronawirus.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Report {
    private Date reportDate;
    private AllTime allTime;
    private Today today;
}

