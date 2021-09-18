package com.mateuszjanczak.koronawirus.mapper;

import com.mateuszjanczak.koronawirus.infrastructure.tests.TGAttributes;
import com.mateuszjanczak.koronawirus.model.tests.*;

import java.util.Date;

public class TestsMapper {
    public static TGReport apply(TGAttributes attributes) {
        return TGReport.builder()
                .reportDate(new Date(attributes.getData()))
                .general(
                        TGGeneral.builder()
                                .infections(attributes.getLiczbaZakazen())
                                .deaths(attributes.getLiczbaZgonow())
                                .recovered(attributes.getWszyscyOzdrowiency())
                                .quarantine(attributes.getKwarantanna())
                                .build()
                )
                .today(
                        TGToday.builder()
                                .infections(attributes.getZakazeniaDzienne())
                                .deaths(
                                        TGTDeath.builder()
                                                .deaths(attributes.getZgonyDzienne())
                                                .covid(attributes.getZgonyCovid())
                                                .coexistent(attributes.getZgonyWspolistniejace())
                                                .build()
                                )
                                .recovered(attributes.getLiczbaOzdrowiencow())
                                .tests(
                                        TGTTest.builder()
                                                .all(attributes.getTesty())
                                                .positive(attributes.getTestyPozytywne())
                                                .poz(attributes.getZleceniaPoz())
                                                .build()
                                )
                                .build()
                )
                .build();
    }
}
