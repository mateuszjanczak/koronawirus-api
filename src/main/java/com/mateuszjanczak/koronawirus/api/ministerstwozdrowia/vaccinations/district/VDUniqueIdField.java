package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.vaccinations.district;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VDUniqueIdField {
    public String name;
    public boolean isSystemMaintained;
}
