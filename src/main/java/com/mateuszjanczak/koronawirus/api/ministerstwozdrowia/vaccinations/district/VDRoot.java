package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.vaccinations.district;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class VDRoot{
    public String objectIdFieldName;
    public VDUniqueIdField uniqueIdField;
    public String globalIdFieldName;
    public VDGeometryProperties geometryProperties;
    public String geometryType;
    public VDSpatialReference spatialReference;
    public List<VDField> fields;
    public List<VDFeature> features;
}

