package com.mateuszjanczak.koronawirus.service;

import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.vaccinations.district.VDAttributes;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.vaccinations.district.VDFeature;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.vaccinations.district.VDRoot;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.vaccinations.district.VaccinationsDistrictAPI;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.vaccinations.general.VGAttributes;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.vaccinations.general.VGFeature;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.vaccinations.general.VGRoot;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.vaccinations.general.VaccinationsGeneralAPI;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.vaccinations.province.VPAttributes;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.vaccinations.province.VPFeature;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.vaccinations.province.VPRoot;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.vaccinations.province.VaccinationsProvinceAPI;
import com.mateuszjanczak.koronawirus.exception.ApiErrorException;
import com.mateuszjanczak.koronawirus.exception.BadDateFormatException;
import com.mateuszjanczak.koronawirus.exception.BadVoivodeshipNameException;
import com.mateuszjanczak.koronawirus.mapper.VaccinationsMapper;
import com.mateuszjanczak.koronawirus.model.vaccinations.district.VDReport;
import com.mateuszjanczak.koronawirus.model.vaccinations.global.VGReport;
import com.mateuszjanczak.koronawirus.model.vaccinations.province.VPReport;
import com.mateuszjanczak.koronawirus.service.interfaces.IVaccinationsService;
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

    private final VaccinationsGeneralAPI vaccinationsGeneralAPI;
    private final VaccinationsProvinceAPI vaccinationsProvinceAPI;
    private final VaccinationsDistrictAPI vaccinationsDistrictAPI;

    public VaccinationsService() {
        this.vaccinationsGeneralAPI = new Retrofit.Builder()
                .baseUrl("https://services9.arcgis.com/RykcEgwHWuMsJXPj/arcgis/rest/services/global_szczepienia_widok3/FeatureServer/0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(VaccinationsGeneralAPI.class);

        this.vaccinationsProvinceAPI = new Retrofit.Builder()
                .baseUrl("https://services9.arcgis.com/RykcEgwHWuMsJXPj/ArcGIS/rest/services/wojewodztwa_szczepienia_widok3/FeatureServer/0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(VaccinationsProvinceAPI.class);

        this.vaccinationsDistrictAPI = new Retrofit.Builder()
                .baseUrl("https://services9.arcgis.com/RykcEgwHWuMsJXPj/ArcGIS/rest/services/powiaty_szczepienia_widok/FeatureServer/0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(VaccinationsDistrictAPI.class);
    }

    @Override
    public VGReport getDailyReport() {

        Call<VGRoot> call = vaccinationsGeneralAPI.getDailyReport();

        try {
            VGRoot response = call.execute().body();
            VGAttributes attributes = Objects.requireNonNull(response).getFeatures().get(0).getAttributes();
            return VaccinationsMapper.apply(attributes);
        } catch (IOException | NullPointerException | ArrayIndexOutOfBoundsException e) {
            throw new ApiErrorException();
        }
    }

    @Override
    public List<VGReport> getPeriodicReport(String from, String to) {

        String[] acceptedFormats = {"yyyy-MM-dd","yyyy-MM-dd HH:mm"};

        try {
            DateUtils.parseDate(from, acceptedFormats);
            DateUtils.parseDate(to, acceptedFormats);
        } catch (ParseException e) {
            throw new BadDateFormatException();
        }

        String condition = "Data BETWEEN '" + from + "' AND '"  + to + "'";
        Call<VGRoot> call = vaccinationsGeneralAPI.getCustomReport(condition);

        try {
            VGRoot response = call.execute().body();
            return Objects
                    .requireNonNull(response)
                    .getFeatures()
                    .stream()
                    .map(VGFeature::getAttributes)
                    .map(VaccinationsMapper::apply)
                    .collect(Collectors.toList());
        } catch (IOException | NullPointerException e) {
            System.out.println(e.getMessage());
            throw new ApiErrorException();
        }
    }

    @Override
    public List<VPReport> getAllProvinceReports() {

        Call<VPRoot> call = vaccinationsProvinceAPI.getAllReports();

        try {
            VPRoot response = call.execute().body();
            return Objects
                    .requireNonNull(response)
                    .getFeatures()
                    .stream()
                    .map(VPFeature::getAttributes)
                    .map(VaccinationsMapper::apply)
                    .collect(Collectors.toList());
        } catch (IOException | NullPointerException e) {
            System.out.println(e.getMessage());
            throw new ApiErrorException();
        }
    }

    @Override
    public VPReport getReportByProvince(String province) {

        String condition = "jpt_nazwa_ = '" + province + "'";

        Call<VPRoot> call = vaccinationsProvinceAPI.getCustomReport(condition);

        try {
            VPRoot response = call.execute().body();
            VPAttributes attributes = Objects.requireNonNull(response).getFeatures().get(0).getAttributes();
            return VaccinationsMapper.apply(attributes);
        } catch (IndexOutOfBoundsException e) {
            throw new BadVoivodeshipNameException();
        } catch (IOException | NullPointerException e) {
            throw new ApiErrorException();
        }
    }

    @Override
    public List<VDReport> getAllDistrictReports() {
        Call<VDRoot> call = vaccinationsDistrictAPI.getAllReports();

        try {
            VDRoot response = call.execute().body();
            return Objects
                    .requireNonNull(response)
                    .getFeatures()
                    .stream()
                    .map(VDFeature::getAttributes)
                    .map(VaccinationsMapper::apply)
                    .collect(Collectors.toList());
        } catch (IOException | NullPointerException e) {
            throw new ApiErrorException();
        }
    }

    @Override
    public VDReport getReportByDistrict(String district) {

        String condition = "jpt_nazwa_ = '" + district + "' ";

        Call<VDRoot> call = vaccinationsDistrictAPI.getCustomReport(condition);

        try {
            VDRoot response = call.execute().body();
            VDAttributes attributes = Objects.requireNonNull(response).getFeatures().get(0).getAttributes();
            return VaccinationsMapper.apply(attributes);
        } catch (IndexOutOfBoundsException e) {
            throw new BadVoivodeshipNameException();
        } catch (IOException | NullPointerException e) {
            throw new ApiErrorException();
        }
    }
}
