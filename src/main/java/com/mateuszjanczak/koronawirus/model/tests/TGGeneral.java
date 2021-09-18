package com.mateuszjanczak.koronawirus.model.tests;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TGGeneral {
    private Integer infections;
    private Integer deaths;
    private Integer recovered;
    private Integer quarantine;
}
