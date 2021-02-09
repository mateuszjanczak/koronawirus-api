package com.mateuszjanczak.koronawirus.service;

import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.covid.district.CDAttributes;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.covid.district.CDFeature;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.covid.district.CDRoot;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.covid.district.CovidDistrictAPI;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.covid.general.CGAttributes;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.covid.general.CGFeature;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.covid.general.CGRoot;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.covid.general.CovidGeneralAPI;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.covid.province.CPAttributes;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.covid.province.CPFeature;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.covid.province.CPRoot;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.covid.province.CovidProvinceAPI;
import com.mateuszjanczak.koronawirus.exception.ApiErrorException;
import com.mateuszjanczak.koronawirus.exception.BadDateFormatException;
import com.mateuszjanczak.koronawirus.exception.BadVoivodeshipNameException;
import com.mateuszjanczak.koronawirus.mapper.CovidMapper;
import com.mateuszjanczak.koronawirus.model.covid.district.CDReport;
import com.mateuszjanczak.koronawirus.model.covid.global.CGReport;
import com.mateuszjanczak.koronawirus.model.covid.province.CPReport;
import com.mateuszjanczak.koronawirus.service.interfaces.ICovidService;
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

    private final CovidGeneralAPI covidGeneralAPI;
    private final CovidProvinceAPI covidProvinceAPI;
    private final CovidDistrictAPI covidDistrictAPI;

    public CovidService() {
        this.covidGeneralAPI = new Retrofit.Builder()
                .baseUrl("https://services9.arcgis.com/RykcEgwHWuMsJXPj/arcgis/rest/services/global_corona_widok2/FeatureServer/0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CovidGeneralAPI.class);

        this.covidProvinceAPI = new Retrofit.Builder()
                .baseUrl("https://services9.arcgis.com/RykcEgwHWuMsJXPj/arcgis/rest/services/wojewodztwa_corona_widok/FeatureServer/0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CovidProvinceAPI.class);

        this.covidDistrictAPI = new Retrofit.Builder()
                .baseUrl("https://services9.arcgis.com/RykcEgwHWuMsJXPj/ArcGIS/rest/services/powiaty_corona_widok_woj/FeatureServer/0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CovidDistrictAPI.class);
    }


    @Override
    public CGReport getDailyReport() {

        Call<CGRoot> call = covidGeneralAPI.getDailyReport();

        try {
            CGRoot response = call.execute().body();
            CGAttributes CGAttributes = Objects.requireNonNull(response).getFeatures().get(0).getAttributes();
            return CovidMapper.apply(CGAttributes);
        } catch (IOException | NullPointerException e) {
            throw new ApiErrorException();
        }
    }

    @Override
    public List<CGReport> getPeriodicReport(String from, String to) {

        String[] acceptedFormats = {"yyyy-MM-dd","yyyy-MM-dd HH:mm"};

        try {
            DateUtils.parseDate(from, acceptedFormats);
            DateUtils.parseDate(to, acceptedFormats);
        } catch (ParseException e) {
            throw new BadDateFormatException();
        }

        String condition = "Data BETWEEN '" + from + "' AND '"  + to + "'";
        Call<CGRoot> call = covidGeneralAPI.getCustomReport(condition);

        try {
            CGRoot response = call.execute().body();
            return Objects
                    .requireNonNull(response)
                    .getFeatures()
                    .stream()
                    .map(CGFeature::getAttributes)
                    .map(CovidMapper::apply)
                    .collect(Collectors.toList());
        } catch (IOException | NullPointerException e) {
            throw new ApiErrorException();
        }
    }

    @Override
    public CPReport getReportByProvince(String voivodeship) {

        String condition = "jpt_nazwa_ = '" + voivodeship + "' OR Nazwa_filter = '" + voivodeship + "'";

        Call<CPRoot> call = covidProvinceAPI.getCustomReport(condition);

        try {
            CPRoot response = call.execute().body();
            CPAttributes attributes = Objects.requireNonNull(response).getFeatures().get(0).getAttributes();
            return CovidMapper.apply(attributes);
        } catch (IndexOutOfBoundsException e) {
            throw new BadVoivodeshipNameException();
        } catch (IOException | NullPointerException e) {
            throw new ApiErrorException();
        }

    }

    @Override
    public List<CPReport> getAllProvinceReports() {

        Call<CPRoot> call = covidProvinceAPI.getAllReports();

        try {
            CPRoot response = call.execute().body();
            return Objects
                    .requireNonNull(response)
                    .getFeatures()
                    .stream()
                    .map(CPFeature::getAttributes)
                    .map(CovidMapper::apply)
                    .collect(Collectors.toList());
        } catch (IOException | NullPointerException e) {
            throw new ApiErrorException();
        }
    }

    @Override
    public List<CDReport> getAllDistrictReports() {

        Call<CDRoot> call = covidDistrictAPI.getAllReports();

        try {
            CDRoot response = call.execute().body();
            return Objects
                    .requireNonNull(response)
                    .getFeatures()
                    .stream()
                    .map(CDFeature::getAttributes)
                    .map(CovidMapper::apply)
                    .collect(Collectors.toList());
        } catch (IOException | NullPointerException e) {
            throw new ApiErrorException();
        }
    }

    @Override
    public CDReport getReportByDistrict(String district) {

        String condition = "jpt_nazwa_ = '" + district + "' ";

        Call<CDRoot> call = covidDistrictAPI.getCustomReport(condition);

        try {
            CDRoot response = call.execute().body();
            CDAttributes attributes = Objects.requireNonNull(response).getFeatures().get(0).getAttributes();
            return CovidMapper.apply(attributes);
        } catch (IndexOutOfBoundsException e) {
            throw new BadVoivodeshipNameException();
        } catch (IOException | NullPointerException e) {
            throw new ApiErrorException();
        }
    }
}
