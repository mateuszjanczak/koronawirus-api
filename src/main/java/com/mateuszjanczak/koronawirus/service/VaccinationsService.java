package com.mateuszjanczak.koronawirus.service;

import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.model.ExtendedRoot;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.model.Feature;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.model.Root;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.vaccinations.district.VDAttributes;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.vaccinations.district.VaccinationsDistrictAPI;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.vaccinations.general.VGAttributes;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.vaccinations.general.VaccinationsGeneralAPI;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.vaccinations.points.VPPAttributes;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.vaccinations.points.VaccinationsPointsAPI;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.vaccinations.province.VPAttributes;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.vaccinations.province.VaccinationsProvinceAPI;
import com.mateuszjanczak.koronawirus.exception.ApiErrorException;
import com.mateuszjanczak.koronawirus.exception.BadDateFormatException;
import com.mateuszjanczak.koronawirus.exception.BadVoivodeshipNameException;
import com.mateuszjanczak.koronawirus.mapper.VaccinationsMapper;
import com.mateuszjanczak.koronawirus.model.vaccinations.district.VDReport;
import com.mateuszjanczak.koronawirus.model.vaccinations.global.VGReport;
import com.mateuszjanczak.koronawirus.model.vaccinations.points.VPPReport;
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
    private final VaccinationsPointsAPI vaccinationsPointsAPI;

    public VaccinationsService() {
        this.vaccinationsGeneralAPI = new Retrofit.Builder()
                .baseUrl("https://services-eu1.arcgis.com/zk7YlClTgerl62BY/ArcGIS/rest/services/global_szczepienia_widok3/FeatureServer/0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(VaccinationsGeneralAPI.class);

        this.vaccinationsProvinceAPI = new Retrofit.Builder()
                .baseUrl("https://services-eu1.arcgis.com/zk7YlClTgerl62BY/ArcGIS/rest/services/wojewodztwa_szczepienia_widok3/FeatureServer/0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(VaccinationsProvinceAPI.class);

        this.vaccinationsDistrictAPI = new Retrofit.Builder()
                .baseUrl("https://services-eu1.arcgis.com/zk7YlClTgerl62BY/ArcGIS/rest/services/powiaty_szczepienia_widok/FeatureServer/0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(VaccinationsDistrictAPI.class);

        this.vaccinationsPointsAPI = new Retrofit.Builder()
                .baseUrl("https://services-eu1.arcgis.com/zk7YlClTgerl62BY/ArcGIS/rest/services/punkty_szczepien_widok/FeatureServer/0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(VaccinationsPointsAPI.class);
    }

    @Override
    public VGReport getDailyReport() {

        Call<Root<VGAttributes>> call = vaccinationsGeneralAPI.getDailyReport();

        try {
            Root<VGAttributes> response = call.execute().body();
            VGAttributes attributes = Objects.requireNonNull(response).getFeatures().get(0).getAttributes();
            return VaccinationsMapper.apply(attributes);
        } catch (IOException | NullPointerException | IndexOutOfBoundsException e) {
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
        Call<Root<VGAttributes>> call = vaccinationsGeneralAPI.getCustomReport(condition);

        try {
            Root<VGAttributes> response = call.execute().body();
            return Objects
                    .requireNonNull(response)
                    .getFeatures()
                    .stream()
                    .map(Feature::getAttributes)
                    .map(VaccinationsMapper::apply)
                    .collect(Collectors.toList());
        } catch (IOException | NullPointerException e) {
            System.out.println(e.getMessage());
            throw new ApiErrorException();
        }
    }

    @Override
    public List<VPReport> getAllProvinceReports() {

        Call<ExtendedRoot<VPAttributes>> call = vaccinationsProvinceAPI.getAllReports();

        try {
            ExtendedRoot<VPAttributes> response = call.execute().body();
            return Objects
                    .requireNonNull(response)
                    .getFeatures()
                    .stream()
                    .map(Feature::getAttributes)
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

        Call<ExtendedRoot<VPAttributes>> call = vaccinationsProvinceAPI.getCustomReport(condition);

        try {
            ExtendedRoot<VPAttributes> response = call.execute().body();
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
        Call<ExtendedRoot<VDAttributes>> call = vaccinationsDistrictAPI.getAllReports();

        try {
            ExtendedRoot<VDAttributes> response = call.execute().body();
            return Objects
                    .requireNonNull(response)
                    .getFeatures()
                    .stream()
                    .map(Feature::getAttributes)
                    .map(VaccinationsMapper::apply)
                    .collect(Collectors.toList());
        } catch (IOException | NullPointerException e) {
            throw new ApiErrorException();
        }
    }

    @Override
    public VDReport getReportByDistrict(String district) {

        String condition = "jpt_nazwa_ = '" + district + "' ";

        Call<ExtendedRoot<VDAttributes>> call = vaccinationsDistrictAPI.getCustomReport(condition);

        try {
            ExtendedRoot<VDAttributes> response = call.execute().body();
            VDAttributes attributes = Objects.requireNonNull(response).getFeatures().get(0).getAttributes();
            return VaccinationsMapper.apply(attributes);
        } catch (IndexOutOfBoundsException e) {
            throw new BadVoivodeshipNameException();
        } catch (IOException | NullPointerException e) {
            throw new ApiErrorException();
        }
    }

    @Override
    public List<VPPReport> getAllPointsReports() {
        Call<ExtendedRoot<VPPAttributes>> call = vaccinationsPointsAPI.getAllReports();

        try {
            ExtendedRoot<VPPAttributes> response = call.execute().body();
            return Objects
                    .requireNonNull(response)
                    .getFeatures()
                    .stream()
                    .skip(1)
                    .map(Feature::getAttributes)
                    .map(VaccinationsMapper::apply)
                    .collect(Collectors.toList());
        } catch (IOException | NullPointerException e) {
            throw new ApiErrorException();
        }
    }

    @Override
    public VPPReport getReportByName(String name) {

        String condition = "NAZWA = '" + name + "' ";

        Call<ExtendedRoot<VPPAttributes>> call = vaccinationsPointsAPI.getCustomReport(condition);

        try {
            ExtendedRoot<VPPAttributes> response = call.execute().body();
            VPPAttributes attributes = Objects.requireNonNull(response).getFeatures().get(0).getAttributes();
            return VaccinationsMapper.apply(attributes);
        } catch (IndexOutOfBoundsException e) {
            throw new BadVoivodeshipNameException();
        } catch (IOException | NullPointerException e) {
            throw new ApiErrorException();
        }
    }
}
