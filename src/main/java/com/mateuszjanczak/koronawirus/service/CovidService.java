package com.mateuszjanczak.koronawirus.service;

import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.MZAPI;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.model.Attributes;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.model.MZRoot;
import com.mateuszjanczak.koronawirus.model.*;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

@Service
public class CovidService implements ICovidService {

    private final MZAPI MZAPI;

    public CovidService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://services9.arcgis.com/RykcEgwHWuMsJXPj/arcgis/rest/services/global_corona_widok2/FeatureServer/0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        this.MZAPI = retrofit.create(MZAPI.class);
    }

    @Override
    public Report getDailyReport() {

        Call<MZRoot> call = MZAPI.getDailyReport();
        try {
            MZRoot response = call.execute().body();
            Attributes attributes = Objects.requireNonNull(response).getFeatures().get(0).getAttributes();


            return Report.builder()
                    .reportDate(new Date(attributes.getData()))
                    .allTime(AllTime.builder()
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
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
