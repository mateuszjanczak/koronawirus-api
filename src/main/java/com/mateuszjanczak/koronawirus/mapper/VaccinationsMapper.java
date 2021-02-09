package com.mateuszjanczak.koronawirus.mapper;

import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.vaccinations.VaccinationsAttributes;
import com.mateuszjanczak.koronawirus.model.vaccinations.*;

import java.util.Arrays;
import java.util.Date;

public class VaccinationsMapper {
    public static VaccinationsReport apply(VaccinationsAttributes attributes) {
        return VaccinationsReport.builder()
                .reportDate(new Date(attributes.getData()))
                .general(General.builder()
                        .vaccinations(attributes.getSzczepienia_suma())
                        .firstDoses(attributes.getDawka_1_suma())
                        .secondDoses(attributes.getDawka_2_suma())
                        .lostDoses(attributes.getDawki_utracone())
                        .adverseReactions(attributes.getOdczyny_niepozadane())
                        .vaccinesDeliveredToPL(attributes.getSuma_dawek_polska())
                        .vaccinesDeliveredToPoints(attributes.getLiczba_dawek_punkty())
                        .availabilityInStock(attributes.getStan_magazyn())
                        .ageTypes(
                                Arrays.asList(
                                        VaccinationsAgeType.builder().ageType(AgeType.AR0_17).vaccinations(attributes.getSzczepienia0_17()).build(),
                                        VaccinationsAgeType.builder().ageType(AgeType.AR18_30).vaccinations(attributes.getSzczepienia18_30()).build(),
                                        VaccinationsAgeType.builder().ageType(AgeType.AR31_40).vaccinations(attributes.getSzczepienia31_40()).build(),
                                        VaccinationsAgeType.builder().ageType(AgeType.AR41_50).vaccinations(attributes.getSzczepienia41_50()).build(),
                                        VaccinationsAgeType.builder().ageType(AgeType.AR51_60).vaccinations(attributes.getSzczepienia51_60()).build(),
                                        VaccinationsAgeType.builder().ageType(AgeType.AR61_70).vaccinations(attributes.getSzczepienia61_70()).build(),
                                        VaccinationsAgeType.builder().ageType(AgeType.AR71_75).vaccinations(attributes.getSzczepienia71_75()).build(),
                                        VaccinationsAgeType.builder().ageType(AgeType.AR75_).vaccinations(attributes.getSzczepienia75_()).build(),
                                        VaccinationsAgeType.builder().ageType(AgeType.AR_UNDEFINED).vaccinations(attributes.getSzczepienia_wiek_nieustalono()).build(),
                                        VaccinationsAgeType.builder().ageType(AgeType.AG_FEMALE).vaccinations(attributes.getSzczepienia_kobiety()).build(),
                                        VaccinationsAgeType.builder().ageType(AgeType.AG_MALE).vaccinations(attributes.getSzczepienia_mezczyzni()).build(),
                                        VaccinationsAgeType.builder().ageType(AgeType.AG_UNDEFINED).vaccinations(attributes.getSzczepienia_plec_nieustalono()).build()
                                )
                        )
                        .build())
                .today(Today.builder()
                        .vaccinations(attributes.getSzczepienia_dziennie())
                        .firstDoses(attributes.getSzczepienia_dziennie() - attributes.getDawka_2_dziennie())
                        .secondDoses(attributes.getDawka_2_dziennie())
                        .build())
                .build();
    }
}
