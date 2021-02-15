package com.mateuszjanczak.koronawirus.model.vaccinations.points;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VPPReport {
    String name;
    VPPLocation location;
    VPPContact contact;
    VPPGeneral general;
    VPPToday today;
}
