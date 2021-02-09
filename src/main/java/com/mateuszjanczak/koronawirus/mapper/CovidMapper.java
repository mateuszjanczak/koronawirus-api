package com.mateuszjanczak.koronawirus.mapper;

import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.covid19.CovidAttributes;
import com.mateuszjanczak.koronawirus.model.covid.*;

import java.util.Arrays;
import java.util.Date;

public class CovidMapper {
    public static CovidReport apply(CovidAttributes covidAttributes) {
        return CovidReport.builder()
                .reportDate(new Date(covidAttributes.getData()))
                .allTime(AllTime.builder()
                        .deaths(covidAttributes.getLiczba_zgonow())
                        .infections(covidAttributes.getLiczba_zakazen())
                        .recovered(covidAttributes.getLiczba_ozdrowiencow())
                        .build()
                )
                .today(Today.builder()
                        .newInfections(covidAttributes.getZakazenia_dzienne())
                        .newDeaths(covidAttributes.getZgony_dzienne())
                        .deathAgeRange(
                                Arrays.asList(
                                        DeathAgeRange.builder().ageRange(AgeRange.AR0_10).deaths(covidAttributes.getZgony0_10()).build(),
                                        DeathAgeRange.builder().ageRange(AgeRange.AR11_20).deaths(covidAttributes.getZgony11_20()).build(),
                                        DeathAgeRange.builder().ageRange(AgeRange.AR21_30).deaths(covidAttributes.getZgony21_30()).build(),
                                        DeathAgeRange.builder().ageRange(AgeRange.AR31_40).deaths(covidAttributes.getZgony31_40()).build(),
                                        DeathAgeRange.builder().ageRange(AgeRange.AR41_50).deaths(covidAttributes.getZgony41_50()).build(),
                                        DeathAgeRange.builder().ageRange(AgeRange.AR51_60).deaths(covidAttributes.getZgony51_60()).build(),
                                        DeathAgeRange.builder().ageRange(AgeRange.AR61_70).deaths(covidAttributes.getZgony61_70()).build(),
                                        DeathAgeRange.builder().ageRange(AgeRange.AR71_80).deaths(covidAttributes.getZgony70_71()).build(),
                                        DeathAgeRange.builder().ageRange(AgeRange.AR81_).deaths(covidAttributes.getZgony81_()).build()
                                )
                        )
                        .deathGender(DeathGender.builder()
                                .female(covidAttributes.getZgony_kobiety())
                                .male(covidAttributes.getZgony_mezczyzni())
                                .build())
                        .build())
                .build();
    }
}
