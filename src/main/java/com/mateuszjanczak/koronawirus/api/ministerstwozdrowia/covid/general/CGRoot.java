package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.covid.general;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CGRoot {
    public String objectIdFieldName;
    public CGUniqueIdField uniqueIdField;
    public String globalIdFieldName;
    public List<CGField> fields;
    public List<CGFeature> features;
}