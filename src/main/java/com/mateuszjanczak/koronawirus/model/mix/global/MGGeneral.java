package com.mateuszjanczak.koronawirus.model.mix.global;

import com.mateuszjanczak.koronawirus.model.covid.global.CGGeneral;
import com.mateuszjanczak.koronawirus.model.vaccinations.global.VGGeneral;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MGGeneral {
    private VGGeneral vaccinations;
    private CGGeneral infections;
}
