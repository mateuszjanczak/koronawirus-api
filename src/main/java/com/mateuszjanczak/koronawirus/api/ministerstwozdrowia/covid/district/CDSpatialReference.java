package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.covid.district;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CDSpatialReference {
    public int wkid;
    public int latestWkid;
}
