package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.covid.province;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CPUniqueIdField {
    public String name;
    public boolean isSystemMaintained;
}
