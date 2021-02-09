package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.covid.district;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class
CDUniqueIdField {
    public String name;
    public boolean isSystemMaintained;
}
