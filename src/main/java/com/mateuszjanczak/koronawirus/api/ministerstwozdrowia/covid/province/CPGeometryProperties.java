package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.covid.province;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CPGeometryProperties {
    public String shapeAreaFieldName;
    public String shapeLengthFieldName;
    public String units;
}
