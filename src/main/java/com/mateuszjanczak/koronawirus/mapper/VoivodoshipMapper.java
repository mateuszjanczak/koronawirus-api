package com.mateuszjanczak.koronawirus.mapper;

import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.voivodeship.VoivodeshipAttributes;
import com.mateuszjanczak.koronawirus.model.voivodeship.*;

import java.util.Date;

public class VoivodoshipMapper {
    public static VoivodeshipReport apply(VoivodeshipAttributes attributes) {
        return VoivodeshipReport.builder()
                .voivodeship(attributes.getJpt_nazwa_())
                .reportDate(new Date())
                .general(General.builder()
                        .quarantine(attributes.getKwarantanna())
                        .infections(attributes.getSum_confirmed())
                        .infectionRatioPer10kPopulation(attributes.getPotwierdzone_10_tys_osob())
                        .deaths(attributes.getSum_deaths())
                        .recovered(attributes.getSum_recovered())
                        .population(attributes.getPopulacja())
                        .build())
                .today(Today.builder()
                        .infections(attributes.getPotwierdzone_dzienne())
                        .deaths(attributes.getSmiertelne_dzienne())
                        .test(Test.builder()
                                .all(attributes.getTesty())
                                .positive(attributes.getTesty_pozytywne())
                                .negative(attributes.getTesty_negatywne())
                                .poz(attributes.getZlecenia_poz())
                                .other(attributes.getTesty_pozostale())
                                .build())
                        .deathType(DeathType.builder()
                                .covid(attributes.getZgony_covid())
                                .comorbidities(attributes.getZgony_wspolistniejace())
                                .build())
                        .build())
                .build();
    }
}
