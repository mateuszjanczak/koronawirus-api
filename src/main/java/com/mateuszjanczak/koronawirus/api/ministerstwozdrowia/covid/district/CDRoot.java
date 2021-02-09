package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.covid.district;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CDRoot {
    public String objectIdFieldName;
    public CDUniqueIdField uniqueIdField;
    public String globalIdFieldName;
    public CDGeometryProperties geometryProperties;
    public String geometryType;
    public CDSpatialReference spatialReference;
    public List<CDField> fields;
    public List<CDFeature> features;
}

