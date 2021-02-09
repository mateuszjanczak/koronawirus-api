package com.mateuszjanczak.koronawirus.mapper;

import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.covid.CovidAttributes;
import com.mateuszjanczak.koronawirus.model.covid.*;

import java.util.Arrays;
import java.util.Date;

public class CovidMapper {
    public static CovidReport apply(CovidAttributes attributes) {
        return CovidReport.builder()
                .reportDate(new Date(attributes.getData()))
                .general(General.builder()
                        .deaths(attributes.getLiczba_zgonow())
                        .infections(attributes.getLiczba_zakazen())
                        .recovered(attributes.getLiczba_ozdrowiencow())
                        .build()
                )
                .today(Today.builder()
                        .newInfections(attributes.getZakazenia_dzienne())
                        .newDeaths(attributes.getZgony_dzienne())
                        .deathAgeRange(
                                Arrays.asList(
                                        DeathAgeRange.builder().ageRange(AgeRange.AR0_10).deaths(attributes.getZgony0_10()).build(),
                                        DeathAgeRange.builder().ageRange(AgeRange.AR11_20).deaths(attributes.getZgony11_20()).build(),
                                        DeathAgeRange.builder().ageRange(AgeRange.AR21_30).deaths(attributes.getZgony21_30()).build(),
                                        DeathAgeRange.builder().ageRange(AgeRange.AR31_40).deaths(attributes.getZgony31_40()).build(),
                                        DeathAgeRange.builder().ageRange(AgeRange.AR41_50).deaths(attributes.getZgony41_50()).build(),
                                        DeathAgeRange.builder().ageRange(AgeRange.AR51_60).deaths(attributes.getZgony51_60()).build(),
                                        DeathAgeRange.builder().ageRange(AgeRange.AR61_70).deaths(attributes.getZgony61_70()).build(),
                                        DeathAgeRange.builder().ageRange(AgeRange.AR71_80).deaths(attributes.getZgony70_71()).build(),
                                        DeathAgeRange.builder().ageRange(AgeRange.AR81_).deaths(attributes.getZgony81_()).build()
                                )
                        )
                        .deathGender(DeathGender.builder()
                                .female(attributes.getZgony_kobiety())
                                .male(attributes.getZgony_mezczyzni())
                                .build())
                        .build())
                .build();
    }
}
