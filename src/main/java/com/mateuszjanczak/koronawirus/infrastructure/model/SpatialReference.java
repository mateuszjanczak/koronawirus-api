package com.mateuszjanczak.koronawirus.infrastructure.model;

public class SpatialReference {
    public int wkid;
    public int latestWkid;

    public SpatialReference() {
    }

    public SpatialReference(int wkid, int latestWkid) {
        this.wkid = wkid;
        this.latestWkid = latestWkid;
    }

    public int getWkid() {
        return wkid;
    }

    public void setWkid(int wkid) {
        this.wkid = wkid;
    }

    public int getLatestWkid() {
        return latestWkid;
    }

    public void setLatestWkid(int latestWkid) {
        this.latestWkid = latestWkid;
    }
}
