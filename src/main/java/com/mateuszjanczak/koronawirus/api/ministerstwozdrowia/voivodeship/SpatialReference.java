package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.voivodeship;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SpatialReference {
    private Long wkid;
    private Long latestWkid;
}
