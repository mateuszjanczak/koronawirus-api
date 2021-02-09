package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.vaccinations.district;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VDGeometryProperties {
    public String shapeAreaFieldName;
    public String shapeLengthFieldName;
    public String units;
}
