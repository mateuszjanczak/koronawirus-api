package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.vaccinations;

import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.model.Root;
import lombok.Data;

import java.util.List;

@Data
public class VaccinationsRoot extends Root {
    public List<VaccinationsFeature> features;
}
