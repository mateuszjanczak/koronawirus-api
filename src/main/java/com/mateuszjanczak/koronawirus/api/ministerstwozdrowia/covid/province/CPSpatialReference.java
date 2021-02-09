package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.covid.province;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CPSpatialReference {
    public int wkid;
    public int latestWkid;
}
