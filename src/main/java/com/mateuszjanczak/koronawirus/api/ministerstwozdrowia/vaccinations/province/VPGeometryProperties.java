package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.vaccinations.province;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VPGeometryProperties {
    public String shapeAreaFieldName;
    public String shapeLengthFieldName;
    public String units;
}
