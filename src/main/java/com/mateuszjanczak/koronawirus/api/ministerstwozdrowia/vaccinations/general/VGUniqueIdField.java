package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.vaccinations.general;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VGUniqueIdField {
    public String name;
    public boolean isSystemMaintained;
}
