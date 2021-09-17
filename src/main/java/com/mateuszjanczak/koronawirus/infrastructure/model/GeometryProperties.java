package com.mateuszjanczak.koronawirus.infrastructure.model;

public class GeometryProperties {
    public String shapeAreaFieldName;
    public String shapeLengthFieldName;
    public String units;

    public GeometryProperties() {
    }

    public GeometryProperties(String shapeAreaFieldName, String shapeLengthFieldName, String units) {
        this.shapeAreaFieldName = shapeAreaFieldName;
        this.shapeLengthFieldName = shapeLengthFieldName;
        this.units = units;
    }

    public String getShapeAreaFieldName() {
        return shapeAreaFieldName;
    }

    public void setShapeAreaFieldName(String shapeAreaFieldName) {
        this.shapeAreaFieldName = shapeAreaFieldName;
    }

    public String getShapeLengthFieldName() {
        return shapeLengthFieldName;
    }

    public void setShapeLengthFieldName(String shapeLengthFieldName) {
        this.shapeLengthFieldName = shapeLengthFieldName;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }
}
