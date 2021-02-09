package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.covid.general;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CGUniqueIdField {
    public String name;
    public boolean isSystemMaintained;
}
