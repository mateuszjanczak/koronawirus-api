package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.vaccinations.district;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VDSpatialReference {
    public int wkid;
    public int latestWkid;
}
