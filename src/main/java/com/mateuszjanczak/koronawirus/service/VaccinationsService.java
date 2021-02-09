package com.mateuszjanczak.koronawirus.service;

import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.VaccinationsAPI;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.vaccinations.VaccinationsAttributes;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.vaccinations.VaccinationsFeature;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.vaccinations.VaccinationsRoot;
import com.mateuszjanczak.koronawirus.exception.ApiErrorException;
import com.mateuszjanczak.koronawirus.exception.BadDateFormatException;
import com.mateuszjanczak.koronawirus.mapper.VaccinationsMapper;
import com.mateuszjanczak.koronawirus.model.vaccinations.VaccinationsReport;
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
public class VaccinationsService implements IVaccinationsService {

    private final VaccinationsAPI vaccinationsAPI;

    public VaccinationsService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://services9.arcgis.com/RykcEgwHWuMsJXPj/arcgis/rest/services/global_szczepienia_widok3/FeatureServer/0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        this.vaccinationsAPI = retrofit.create(VaccinationsAPI.class);
    }

    @Override
    public VaccinationsReport getDailyReport() {

        Call<VaccinationsRoot> call = vaccinationsAPI.getDailyReport();

        try {
            VaccinationsRoot response = call.execute().body();
            VaccinationsAttributes vaccinationsAttributes = Objects.requireNonNull(response).getFeatures().get(0).getAttributes();
            return VaccinationsMapper.apply(vaccinationsAttributes);
        } catch (IOException | NullPointerException e) {
            throw new ApiErrorException();
        }
    }

    @Override
    public List<VaccinationsReport> getPeriodicReport(String from, String to) {

        String[] acceptedFormats = {"yyyy-MM-dd","yyyy-MM-dd HH:mm"};

        try {
            DateUtils.parseDate(from, acceptedFormats);
            DateUtils.parseDate(to, acceptedFormats);
        } catch (ParseException e) {
            throw new BadDateFormatException();
        }

        String condition = "Data BETWEEN '" + from + "' AND '"  + to + "'";
        Call<VaccinationsRoot> call = vaccinationsAPI.getCustomReport(condition);

        try {
            VaccinationsRoot response = call.execute().body();
            return Objects
                    .requireNonNull(response)
                    .getFeatures()
                    .stream()
                    .map(VaccinationsFeature::getAttributes)
                    .map(VaccinationsMapper::apply)
                    .collect(Collectors.toList());
        } catch (IOException | NullPointerException e) {
            System.out.println(e.getMessage());
            throw new ApiErrorException();
        }
    }
}
