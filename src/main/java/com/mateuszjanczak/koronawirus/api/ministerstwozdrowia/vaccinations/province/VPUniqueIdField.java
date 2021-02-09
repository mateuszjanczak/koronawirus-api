package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.vaccinations.province;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VPUniqueIdField {
    public String name;
    public boolean isSystemMaintained;
}
