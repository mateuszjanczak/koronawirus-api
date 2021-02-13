package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.model;

import java.util.List;

public class Root<T> {
    public String objectIdFieldName;
    public String globalIdFieldName;
    public UniqueIdField uniqueIdField;
    public List<Field> fields;
    public List<Feature<T>> features;

    public Root() {
    }

    public Root(String objectIdFieldName, String globalIdFieldName, UniqueIdField uniqueIdField, List<Field> fields, List<Feature<T>> features) {
        this.objectIdFieldName = objectIdFieldName;
        this.globalIdFieldName = globalIdFieldName;
        this.uniqueIdField = uniqueIdField;
        this.fields = fields;
        this.features = features;
    }

    public String getObjectIdFieldName() {
        return objectIdFieldName;
    }

    public void setObjectIdFieldName(String objectIdFieldName) {
        this.objectIdFieldName = objectIdFieldName;
    }

    public String getGlobalIdFieldName() {
        return globalIdFieldName;
    }

    public void setGlobalIdFieldName(String globalIdFieldName) {
        this.globalIdFieldName = globalIdFieldName;
    }

    public UniqueIdField getUniqueIdField() {
        return uniqueIdField;
    }

    public void setUniqueIdField(UniqueIdField uniqueIdField) {
        this.uniqueIdField = uniqueIdField;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public List<Feature<T>> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature<T>> features) {
        this.features = features;
    }
}
