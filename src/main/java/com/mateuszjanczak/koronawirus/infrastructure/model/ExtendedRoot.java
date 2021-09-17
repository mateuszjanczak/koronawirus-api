package com.mateuszjanczak.koronawirus.infrastructure.model;

import java.util.List;

public class ExtendedRoot<T> extends Root<T> {
    public GeometryProperties geometryProperties;
    public String geometryType;
    public SpatialReference spatialReference;

    public ExtendedRoot() {
    }

    public ExtendedRoot(GeometryProperties geometryProperties, String geometryType, SpatialReference spatialReference) {
        this.geometryProperties = geometryProperties;
        this.geometryType = geometryType;
        this.spatialReference = spatialReference;
    }

    public ExtendedRoot(String objectIdFieldName, String globalIdFieldName, UniqueIdField uniqueIdField, List<Field> fields, List<Feature<T>> features) {
        super(objectIdFieldName, globalIdFieldName, uniqueIdField, fields, features);
    }

    public ExtendedRoot(String objectIdFieldName, String globalIdFieldName, UniqueIdField uniqueIdField, List<Field> fields, List<Feature<T>> features, GeometryProperties geometryProperties, String geometryType, SpatialReference spatialReference) {
        super(objectIdFieldName, globalIdFieldName, uniqueIdField, fields, features);
        this.geometryProperties = geometryProperties;
        this.geometryType = geometryType;
        this.spatialReference = spatialReference;
    }

    public GeometryProperties getGeometryProperties() {
        return geometryProperties;
    }

    public void setGeometryProperties(GeometryProperties geometryProperties) {
        this.geometryProperties = geometryProperties;
    }

    public String getGeometryType() {
        return geometryType;
    }

    public void setGeometryType(String geometryType) {
        this.geometryType = geometryType;
    }

    public SpatialReference getSpatialReference() {
        return spatialReference;
    }

    public void setSpatialReference(SpatialReference spatialReference) {
        this.spatialReference = spatialReference;
    }
}
