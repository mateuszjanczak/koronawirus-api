package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.voivodeship;

import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.model.Root;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class VoivodeshipRoot extends Root {
    private GeometryProperties geometryProperties;
    private String geometryType;
    private SpatialReference spatialReference;
    private List<VoivodeshipFeature> features;
}
