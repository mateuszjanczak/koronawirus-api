package com.mateuszjanczak.koronawirus.mapper;

import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.covid.general.CGAttributes;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.covid.province.CPAttributes;
import com.mateuszjanczak.koronawirus.model.covid.global.*;
import com.mateuszjanczak.koronawirus.model.covid.province.*;

import java.util.Arrays;
import java.util.Date;

public class CovidMapper {
    public static CGReport apply(CGAttributes attributes) {
        return CGReport.builder()
                .reportDate(new Date(attributes.getData()))
                .general(CGGeneral.builder()
                        .deaths(attributes.getLICZBA_ZGONOW())
                        .infections(attributes.getLICZBA_ZAKAZEN())
                        .recovered(attributes.getLICZBA_OZDROWIENCOW())
                        .build()
                )
                .today(CGToday.builder()
                        .newInfections(attributes.getZAKAZENIA_DZIENNE())
                        .newDeaths(attributes.getZGONY_DZIENNE())
                        .deathAgeRanges(
                                Arrays.asList(
                                        CGDeathAgeRange.builder().ageRange(CGAgeRange.AR0_10).deaths(attributes.getZGONY0_10()).build(),
                                        CGDeathAgeRange.builder().ageRange(CGAgeRange.AR11_20).deaths(attributes.getZGONY11_20()).build(),
                                        CGDeathAgeRange.builder().ageRange(CGAgeRange.AR21_30).deaths(attributes.getZGONY21_30()).build(),
                                        CGDeathAgeRange.builder().ageRange(CGAgeRange.AR31_40).deaths(attributes.getZGONY31_40()).build(),
                                        CGDeathAgeRange.builder().ageRange(CGAgeRange.AR41_50).deaths(attributes.getZGONY41_50()).build(),
                                        CGDeathAgeRange.builder().ageRange(CGAgeRange.AR51_60).deaths(attributes.getZGONY51_60()).build(),
                                        CGDeathAgeRange.builder().ageRange(CGAgeRange.AR61_70).deaths(attributes.getZGONY61_70()).build(),
                                        CGDeathAgeRange.builder().ageRange(CGAgeRange.AR71_80).deaths(attributes.getZGONY71_80()).build(),
                                        CGDeathAgeRange.builder().ageRange(CGAgeRange.AR81_).deaths(attributes.getZGONY81_()).build()
                                )
                        )
                        .deathGender(CGDeathGender.builder()
                                .female(attributes.getZGONY_KOBIETY())
                                .male(attributes.getZGONY_MEZCZYZNI())
                                .build())
                        .build())
                .build();
    }

    public static CPReport apply(CPAttributes attributes) {
        return CPReport.builder()
                .voivodeship(attributes.getJpt_nazwa_())
                .reportDate(new Date())
                .general(CPGeneral.builder()
                        .quarantine(attributes.getKWARANTANNA())
                        .infections(attributes.getSUM_Confirmed())
                        .infectionRatioPer10kPopulation(attributes.getPOTWIERDZONE_10_TYS_OSOB())
                        .deaths(attributes.getSUM_Deaths())
                        .recovered(attributes.getSUM_Recovered())
                        .population(attributes.getPopulacja())
                        .build())
                .today(CPToday.builder()
                        .infections(attributes.getPotwierdzone_dzienne())
                        .deaths(attributes.getSmiertelne_dzienne())
                        .test(CPTest.builder()
                                .all(attributes.getTESTY())
                                .positive(attributes.getTESTY_POZYTYWNE())
                                .negative(attributes.getTESTY_NEGATYWNE())
                                .poz(attributes.getZLECENIA_POZ())
                                .other(attributes.getTESTY_POZOSTALE())
                                .build())
                        .deathType(CPDeathType.builder()
                                .covid(attributes.getZGONY_COVID())
                                .comorbidities(attributes.getZGONY_WSPOLISTNIEJACE())
                                .build())
                        .build())
                .build();
    }
}
