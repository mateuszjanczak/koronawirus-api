package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.covid;

import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.model.Root;
import lombok.Data;

import java.util.List;

@Data
public class CovidRoot extends Root {
    public List<CovidFeature> features;
}