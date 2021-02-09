package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.covid.province;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CPRoot {
    public String objectIdFieldName;
    public CPUniqueIdField uniqueIdField;
    public String globalIdFieldName;
    public CPGeometryProperties geometryProperties;
    public String geometryType;
    public CPSpatialReference spatialReference;
    public List<CPField> fields;
    public List<CPFeature> features;
}

