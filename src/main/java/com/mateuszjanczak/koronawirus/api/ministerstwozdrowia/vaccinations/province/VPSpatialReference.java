package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.vaccinations.province;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VPSpatialReference {
    public int wkid;
    public int latestWkid;
}
