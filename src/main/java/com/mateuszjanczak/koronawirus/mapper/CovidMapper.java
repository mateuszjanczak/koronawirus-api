package com.mateuszjanczak.koronawirus.mapper;

import com.mateuszjanczak.koronawirus.infrastructure.covid.district.CDAttributes;
import com.mateuszjanczak.koronawirus.infrastructure.covid.general.CGAttributes;
import com.mateuszjanczak.koronawirus.infrastructure.covid.province.CPAttributes;
import com.mateuszjanczak.koronawirus.model.covid.district.*;
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
                .province(attributes.getJpt_nazwa_())
                .reportDate(new Date())
                .general(CPGeneral.builder()
                        .quarantine(attributes.getKWARANTANNA())
                        .infections(attributes.getSUM_Confirmed())
                        .deaths(attributes.getSUM_Deaths())
                        .recovered(attributes.getSUM_Recovered())
                        .population(attributes.getPopulacja())
                        .build())
                .today(CPToday.builder()
                        .infections(attributes.getPotwierdzone_dzienne())
                        .infectionRatioPer10kPopulation(attributes.getPOTWIERDZONE_10_TYS_OSOB())
                        .tests(CPTest.builder()
                                .all(attributes.getTESTY())
                                .positive(attributes.getTESTY_POZYTYWNE())
                                .negative(attributes.getTESTY_NEGATYWNE())
                                .poz(attributes.getZLECENIA_POZ())
                                .other(attributes.getTESTY_POZOSTALE())
                                .build())
                        .deaths(CPDeath.builder()
                                .deaths(attributes.getSmiertelne_dzienne())
                                .covid(attributes.getZGONY_COVID())
                                .coexistent(attributes.getZGONY_WSPOLISTNIEJACE())
                                .build())
                        .build())
                .build();
    }

    public static CDReport apply(CDAttributes attributes) {
        return CDReport.builder()
                .district(attributes.getJPT_NAZWA_())
                .province(attributes.getWOJEWODZTWO())
                .reportDate(new Date())
                .general(CDGeneral.builder()
                        .population(attributes.getPOPULACJA())
                        .quarantine(attributes.getKWARANTANNA())
                        .build())
                .today(CDToday.builder()
                        .infections(attributes.getPOTWIERDZONE_DZIENNE())
                        .infectionRatioPer10kPopulation(attributes.getPOTWIERDZONE_10_TYS_OSOB())
                        .recovered(attributes.getLICZBA_OZDROWIENCOW())
                        .deaths(CDDeath.builder()
                                .deaths(attributes.getZGONY())
                                .covid(attributes.getZGONY_COVID())
                                .coexistent(attributes.getZGONY_WSPOLISTNIEJACE())
                                .build())
                        .tests(CDTest.builder()
                                .all(attributes.getTESTY())
                                .positive(attributes.getTESTY_POZYTYWNE())
                                .negative(attributes.getTESTY_NEGATYWNE())
                                .poz(attributes.getZLECENIA_POZ())
                                .other(attributes.getTESTY_POZOSTALE())
                                .build())
                        .build())
                .build();
    }
}
