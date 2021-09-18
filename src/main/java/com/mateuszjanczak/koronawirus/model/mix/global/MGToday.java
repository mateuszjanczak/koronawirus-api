package com.mateuszjanczak.koronawirus.model.mix.global;

import com.mateuszjanczak.koronawirus.model.covid.global.CGToday;
import com.mateuszjanczak.koronawirus.model.tests.TGToday;
import com.mateuszjanczak.koronawirus.model.vaccinations.global.VGToday;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MGToday {
    private VGToday vaccinations;
    private CGToday infections;
    private TGToday tests;
}
