package com.mateuszjanczak.koronawirus.model.vaccinations.points;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VPPLocation {
    VPPCoordinates coordinates;
    String address;
    String city;
}
