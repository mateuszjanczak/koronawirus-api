package com.mateuszjanczak.koronawirus.service;

import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.CovidAPI;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.VoivodeshipAPI;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.covid.CovidAttributes;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.covid.CovidFeature;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.covid.CovidRoot;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.voivodeship.VoivodeshipAttributes;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.voivodeship.VoivodeshipFeature;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.voivodeship.VoivodeshipRoot;
import com.mateuszjanczak.koronawirus.exception.ApiErrorException;
import com.mateuszjanczak.koronawirus.exception.BadDateFormatException;
import com.mateuszjanczak.koronawirus.exception.BadVoivodeshipNameException;
import com.mateuszjanczak.koronawirus.mapper.CovidMapper;
import com.mateuszjanczak.koronawirus.mapper.VoivodoshipMapper;
import com.mateuszjanczak.koronawirus.model.covid.*;
import com.mateuszjanczak.koronawirus.model.voivodeship.VoivodeshipReport;
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
    private final VoivodeshipAPI voivodeshipAPI;

    public CovidService() {
        this.covidAPI  = new Retrofit.Builder()
                .baseUrl("https://services9.arcgis.com/RykcEgwHWuMsJXPj/arcgis/rest/services/global_corona_widok2/FeatureServer/0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CovidAPI.class);

        this.voivodeshipAPI  = new Retrofit.Builder()
                .baseUrl("https://services9.arcgis.com/RykcEgwHWuMsJXPj/arcgis/rest/services/wojewodztwa_corona_widok/FeatureServer/0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(VoivodeshipAPI.class);
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
            throw new BadDateFormatException();
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

    @Override
    public VoivodeshipReport getReportByVoivodeship(String voivodeship) {

        String condition = "jpt_nazwa_ = '" + voivodeship + "' OR Nazwa_filter = '" + voivodeship + "'";

        Call<VoivodeshipRoot> call = voivodeshipAPI.getCustomReport(condition);

        try {
            VoivodeshipRoot response = call.execute().body();
            VoivodeshipAttributes voivodeshipAttributes = Objects.requireNonNull(response).getFeatures().get(0).getAttributes();
            return VoivodoshipMapper.apply(voivodeshipAttributes);
        } catch (IndexOutOfBoundsException e) {
            throw new BadVoivodeshipNameException();
        } catch (IOException | NullPointerException e) {
            throw new ApiErrorException();
        }

    }

    @Override
    public List<VoivodeshipReport> getAllVoivodeshipReports() {

        Call<VoivodeshipRoot> call = voivodeshipAPI.getAllReports();

        try {
            VoivodeshipRoot response = call.execute().body();
            return Objects
                    .requireNonNull(response)
                    .getFeatures()
                    .stream()
                    .map(VoivodeshipFeature::getAttributes)
                    .map(VoivodoshipMapper::apply)
                    .collect(Collectors.toList());
        } catch (IOException | NullPointerException e) {
            throw new ApiErrorException();
        }
    }
}
