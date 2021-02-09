package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.model;

import lombok.Data;

import java.util.List;

@Data
public class Root {
    public String objectIdFieldName;
    public UniqueIdField uniqueIdField;
    public String globalIdFieldName;
    public List<Field> fields;
}

