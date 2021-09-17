package com.mateuszjanczak.koronawirus.infrastructure.model;

public class UniqueIdField {
    public String name;
    public boolean isSystemMaintained;

    public UniqueIdField() {
    }

    public UniqueIdField(String name, boolean isSystemMaintained) {
        this.name = name;
        this.isSystemMaintained = isSystemMaintained;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSystemMaintained() {
        return isSystemMaintained;
    }

    public void setSystemMaintained(boolean systemMaintained) {
        isSystemMaintained = systemMaintained;
    }
}
