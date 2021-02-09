package com.mateuszjanczak.koronawirus.model.vaccinations.global;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class VGGeneral {
    private Integer vaccinations;
    private Integer firstDoses;
    private Integer secondDoses;
    private Integer lostDoses;
    private Integer adverseReactions;
    private Integer vaccinesDeliveredToPL;
    private Integer vaccinesDeliveredToPoints;
    private Integer availabilityInStock;
    private List<VGVaccinationsAgeType> ageTypes;
}
