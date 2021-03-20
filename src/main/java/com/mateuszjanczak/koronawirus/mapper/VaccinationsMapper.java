package com.mateuszjanczak.koronawirus.mapper;

import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.vaccinations.district.VDAttributes;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.vaccinations.general.VGAttributes;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.vaccinations.points.VPPAttributes;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.vaccinations.province.VPAttributes;
import com.mateuszjanczak.koronawirus.model.vaccinations.district.VDGeneral;
import com.mateuszjanczak.koronawirus.model.vaccinations.district.VDReport;
import com.mateuszjanczak.koronawirus.model.vaccinations.district.VDToday;
import com.mateuszjanczak.koronawirus.model.vaccinations.global.*;
import com.mateuszjanczak.koronawirus.model.vaccinations.points.*;
import com.mateuszjanczak.koronawirus.model.vaccinations.province.VPGeneral;
import com.mateuszjanczak.koronawirus.model.vaccinations.province.VPReport;
import com.mateuszjanczak.koronawirus.model.vaccinations.province.VPToday;

import java.util.Arrays;
import java.util.Date;

public class VaccinationsMapper {
    public static VGReport apply(VGAttributes attributes) {
        return VGReport.builder()
                .reportDate(new Date(attributes.getData()))
                .general(VGGeneral.builder()
                        .vaccinations(attributes.getSZCZEPIENIA_SUMA())
                        .firstDoses(attributes.getDAWKA_1_SUMA())
                        .secondDoses(attributes.getDAWKA_2_SUMA())
                        .lostDoses(attributes.getDAWKI_UTRACONE())
                        .adverseReactions(attributes.getODCZYNY_NIEPOZADANE())
                        .vaccinesDeliveredToPL(attributes.getSUMA_DAWEK_POLSKA())
                        .vaccinesDeliveredToPoints(attributes.getLICZBA_DAWEK_PUNKTY())
                        .availabilityInStock(attributes.getSTAN_MAGAZYN())
                        .ordersInProgress(attributes.getZamowienia_realizacja())
                        .ageTypes(
                                Arrays.asList(
                                        VGVaccinationsAgeType.builder().ageType(VGAgeType.AR0_17).vaccinations(attributes.getSZCZEPIENIA0_17()).build(),
                                        VGVaccinationsAgeType.builder().ageType(VGAgeType.AR18_30).vaccinations(attributes.getSZCZEPIENIA18_30()).build(),
                                        VGVaccinationsAgeType.builder().ageType(VGAgeType.AR31_40).vaccinations(attributes.getSZCZEPIENIA31_40()).build(),
                                        VGVaccinationsAgeType.builder().ageType(VGAgeType.AR41_50).vaccinations(attributes.getSZCZEPIENIA41_50()).build(),
                                        VGVaccinationsAgeType.builder().ageType(VGAgeType.AR51_60).vaccinations(attributes.getSZCZEPIENIA51_60()).build(),
                                        VGVaccinationsAgeType.builder().ageType(VGAgeType.AR61_70).vaccinations(attributes.getSZCZEPIENIA61_70()).build(),
                                        VGVaccinationsAgeType.builder().ageType(VGAgeType.AR71_75).vaccinations(attributes.getSZCZEPIENIA71_75()).build(),
                                        VGVaccinationsAgeType.builder().ageType(VGAgeType.AR75_).vaccinations(attributes.getSZCZEPIENIA75_()).build(),
                                        VGVaccinationsAgeType.builder().ageType(VGAgeType.AR_UNDEFINED).vaccinations(attributes.getSZCZEPIENIA_WIEK_NIEUSTALONO()).build(),
                                        VGVaccinationsAgeType.builder().ageType(VGAgeType.AG_FEMALE).vaccinations(attributes.getSZCZEPIENIA_KOBIETY()).build(),
                                        VGVaccinationsAgeType.builder().ageType(VGAgeType.AG_MALE).vaccinations(attributes.getSZCZEPIENIA_MEZCZYZNI()).build(),
                                        VGVaccinationsAgeType.builder().ageType(VGAgeType.AG_UNDEFINED).vaccinations(attributes.getSZCZEPIENIA_PLEC_NIEUSTALONO()).build()
                                )
                        )
                        .build())
                .today(VGToday.builder()
                        .vaccinations(attributes.getSZCZEPIENIA_DZIENNIE())
                        .firstDoses(attributes.getSZCZEPIENIA_DZIENNIE() - attributes.getDAWKA_2_DZIENNIE())
                        .secondDoses(attributes.getDAWKA_2_DZIENNIE())
                        .build())
                .build();
    }

    public static VPReport apply(VPAttributes attributes) {
        return VPReport.builder()
                .province(attributes.getJpt_nazwa_())
                .reportDate(new Date())
                .general(VPGeneral.builder()
                        .population(attributes.getPopulacja())
                        .vaccinations(attributes.getSZCZEPIENIA_SUMA())
                        .firstDoses(attributes.getSZCZEPIENIA_SUMA() - attributes.getDAWKA_2_SUMA())
                        .secondDoses(attributes.getDAWKA_2_SUMA())
                        .build()
                )
                .today(VPToday.builder()
                        .vaccinations(attributes.getSZCZEPIENIA_DZIENNIE())
                        .firstDoses(attributes.getSZCZEPIENIA_DZIENNIE() - attributes.getDAWKA_2_DZIENNIE())
                        .secondDoses(attributes.getDAWKA_2_DZIENNIE())
                        .build()
                )
                .build();
    }

    public static VDReport apply(VDAttributes attributes) {
        return VDReport.builder()
                .district(attributes.getJPT_NAZWA_())
                .reportDate(new Date())
                .general(VDGeneral.builder()
                        .population(attributes.getPOPULACJA())
                        .vaccinations(attributes.getSZCZEPIENIA_SUMA())
                        .firstDoses(attributes.getSZCZEPIENIA_SUMA() - attributes.getDAWKA_2_SUMA())
                        .secondDoses(attributes.getDAWKA_2_SUMA())
                        .build()
                )
                .today(VDToday.builder()
                        .vaccinations(attributes.getSZCZEPIENIA_DZIENNIE())
                        .firstDoses(attributes.getSZCZEPIENIA_DZIENNIE() - attributes.getDAWKA_2_DZIENNIE())
                        .secondDoses(attributes.getDAWKA_2_DZIENNIE())
                        .build()
                )
                .build();
    }

    public static VPPReport apply(VPPAttributes attributes) {
        return VPPReport.builder()
                .name(attributes.getNAZWA())
                .location(VPPLocation.builder()
                        .coordinates(VPPCoordinates.builder()
                                .x(attributes.getX())
                                .y(attributes.getY())
                                .build())
                        .address(attributes.getADRES())
                        .city(attributes.getMIEJSCOWOSC())
                        .build())
                .contact(VPPContact.builder()
                        .phone(attributes.getTELEFON())
                        .email(attributes.getADRES_E_MAIL())
                        .nfz(attributes.getODDZIAL_NFZ())
                        .build())
                .general(VPPGeneral.builder()
                        .vaccinations(attributes.getSZCZEPIENIA_SUMA())
                        .build())
                .today(VPPToday.builder()
                        .vaccinations(attributes.getSZCZEPIENIA_DZIENNE())
                        .build())
                .build();
    }
}
