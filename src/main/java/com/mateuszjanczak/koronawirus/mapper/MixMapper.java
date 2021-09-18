package com.mateuszjanczak.koronawirus.mapper;

import com.mateuszjanczak.koronawirus.model.covid.global.CGReport;
import com.mateuszjanczak.koronawirus.model.mix.global.MGGeneral;
import com.mateuszjanczak.koronawirus.model.mix.global.MGReport;
import com.mateuszjanczak.koronawirus.model.mix.global.MGToday;
import com.mateuszjanczak.koronawirus.model.tests.TGReport;
import com.mateuszjanczak.koronawirus.model.vaccinations.global.VGReport;

public class MixMapper {
    public static MGReport apply(CGReport cgReport, VGReport vgReport, TGReport tgReport) {
        return MGReport.builder()
                .reportDate(cgReport.getReportDate())
                .general(
                        MGGeneral.builder()
                                .infections(
                                        cgReport.getGeneral()
                                )
                                .vaccinations(
                                        vgReport.getGeneral()
                                )
                                .tests(
                                        tgReport.getGeneral()
                                )
                                .build()
                )
                .today(
                        MGToday.builder()
                                .infections(
                                        cgReport.getToday()
                                )
                                .vaccinations(
                                        vgReport.getToday()
                                )
                                .tests(
                                        tgReport.getToday()
                                )
                                .build()
                )
                .build();
    }
}
