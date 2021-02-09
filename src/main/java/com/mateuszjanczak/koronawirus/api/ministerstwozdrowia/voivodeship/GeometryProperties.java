package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.voivodeship;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GeometryProperties {
    private String shapeAreaFieldName;
    private String shapeLengthFieldName;
    private String units;
}
