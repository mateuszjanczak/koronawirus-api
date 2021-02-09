package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.vaccinations.general;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class VGRoot{
    public String objectIdFieldName;
    public VGUniqueIdField uniqueIdField;
    public String globalIdFieldName;
    public List<VGField> fields;
    public List<VGFeature> features;
}


