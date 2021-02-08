package com.mateuszjanczak.koronawirus.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AllTime {
    private int infections;
    private int deaths;
    private int recovered;
}
