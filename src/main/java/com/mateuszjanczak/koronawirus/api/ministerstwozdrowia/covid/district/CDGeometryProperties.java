package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.covid.district;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CDGeometryProperties {
    public String shapeAreaFieldName;
    public String shapeLengthFieldName;
    public String units;
}
