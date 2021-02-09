package com.mateuszjanczak.koronawirus.service;

import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.covid19.CovidAPI;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.vaccinations.VaccinationsAPI;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.covid19.CovidAttributes;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.covid19.CovidFeature;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.covid19.CovidRoot;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.model.Root;
import com.mateuszjanczak.koronawirus.exception.ApiErrorException;
import com.mateuszjanczak.koronawirus.exception.BadFormatException;
import com.mateuszjanczak.koronawirus.mapper.CovidMapper;
import com.mateuszjanczak.koronawirus.model.covid.*;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CovidService implements ICovidService {

    private final CovidAPI covidAPI;

    public CovidService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://services9.arcgis.com/RykcEgwHWuMsJXPj/arcgis/rest/services/global_corona_widok2/FeatureServer/0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        this.covidAPI = retrofit.create(CovidAPI.class);
    }


    @Override
    public CovidReport getDailyReport() {

        Call<CovidRoot> call = covidAPI.getDailyReport();

        try {
            CovidRoot response = call.execute().body();
            CovidAttributes covidAttributes = Objects.requireNonNull(response).getFeatures().get(0).getAttributes();
            return CovidMapper.apply(covidAttributes);
        } catch (IOException | NullPointerException e) {
            throw new ApiErrorException();
        }
    }

    @Override
    public List<CovidReport> getPeriodicReport(String from, String to) {

        String[] acceptedFormats = {"yyyy-MM-dd","yyyy-MM-dd HH:mm"};

        try {
            DateUtils.parseDate(from, acceptedFormats);
            DateUtils.parseDate(to, acceptedFormats);
        } catch (ParseException e) {
            throw new BadFormatException();
        }

        String condition = "Data BETWEEN '" + from + "' AND '"  + to + "'";
        Call<CovidRoot> call = covidAPI.getCustomReport(condition);

        try {
            CovidRoot response = call.execute().body();
            return Objects
                    .requireNonNull(response)
                    .getFeatures()
                    .stream()
                    .map(CovidFeature::getAttributes)
                    .map(CovidMapper::apply)
                    .collect(Collectors.toList());
        } catch (IOException | NullPointerException e) {
            throw new ApiErrorException();
        }
    }
}
