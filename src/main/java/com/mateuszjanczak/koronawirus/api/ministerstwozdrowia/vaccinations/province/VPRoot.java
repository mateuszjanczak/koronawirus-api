package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.vaccinations.province;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class VPRoot{
    public String objectIdFieldName;
    public VPUniqueIdField uniqueIdField;
    public String globalIdFieldName;
    public VPGeometryProperties geometryProperties;
    public String geometryType;
    public VPSpatialReference spatialReference;
    public List<VPField> fields;
    public List<VPFeature> features;
}


