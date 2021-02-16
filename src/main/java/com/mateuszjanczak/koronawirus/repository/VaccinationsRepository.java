package com.mateuszjanczak.koronawirus.repository;

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
import com.mateuszjanczak.koronawirus.mapper.VaccinationsMapper;
import com.mateuszjanczak.koronawirus.model.vaccinations.district.VDReport;
import com.mateuszjanczak.koronawirus.model.vaccinations.global.VGReport;
import com.mateuszjanczak.koronawirus.model.vaccinations.points.VPPReport;
import com.mateuszjanczak.koronawirus.model.vaccinations.province.VPReport;
import org.springframework.stereotype.Repository;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class VaccinationsRepository implements IVaccinationsRepository, ICache {
    private final VaccinationsGeneralAPI vaccinationsGeneralAPI;
    private final VaccinationsProvinceAPI vaccinationsProvinceAPI;
    private final VaccinationsDistrictAPI vaccinationsDistrictAPI;
    private final VaccinationsPointsAPI vaccinationsPointsAPI;

    private VGReport dailyReport;
    private List<VGReport> periodicReport;
    private List<VPReport> provinceReport;
    private List<VDReport> districtReport;
    private List<VPPReport> pointReport;

    public VaccinationsRepository() {
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
    public void fetchAll() {
        fetchDailyReport();
        fetchPeriodicReport();
        fetchAllProvinceReports();
        fetchAllDistrictReports();
        fetchAllPointReports();
    }

    public void fetchDailyReport() {
        Call<Root<VGAttributes>> call = vaccinationsGeneralAPI.getDailyReport();

        try {
            Root<VGAttributes> response = call.execute().body();
            VGAttributes attributes = Objects.requireNonNull(response).getFeatures().get(0).getAttributes();
            dailyReport = VaccinationsMapper.apply(attributes);
        } catch (IOException | NullPointerException | IndexOutOfBoundsException e) {
            throw new ApiErrorException();
        }
    }

    @Override
    public VGReport getDailyReport() {
        return dailyReport;
    }

    public void fetchPeriodicReport() {

        String condition = "1=1";
        Call<Root<VGAttributes>> call = vaccinationsGeneralAPI.getCustomReport(condition);

        try {
            Root<VGAttributes> response = call.execute().body();
            periodicReport = Objects
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
    public List<VGReport> getPeriodicReport(Date from, Date to) {
        return periodicReport.stream().filter(vgReport -> vgReport.getReportDate().before(from) && vgReport.getReportDate().after(to)).collect(Collectors.toList());
    }

    public void fetchAllProvinceReports() {

        Call<ExtendedRoot<VPAttributes>> call = vaccinationsProvinceAPI.getAllReports();

        try {
            ExtendedRoot<VPAttributes> response = call.execute().body();
            provinceReport = Objects
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
    public List<VPReport> getAllProvinceReports() {
        return provinceReport;
    }

    @Override
    public Optional<VPReport> getReportByProvince(String province) {
        return provinceReport.stream().filter(vpReport -> vpReport.getProvince().equals(province)).findFirst();
    }

    public void fetchAllDistrictReports() {

        Call<ExtendedRoot<VDAttributes>> call = vaccinationsDistrictAPI.getAllReports();

        try {
            ExtendedRoot<VDAttributes> response = call.execute().body();
            districtReport = Objects
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
    public List<VDReport> getAllDistrictReports() {
        return districtReport;
    }

    @Override
    public Optional<VDReport> getReportByDistrict(String district) {
        return districtReport.stream().filter(vdReport -> vdReport.getDistrict().equals(district)).findFirst();
    }

    public void fetchAllPointReports() {
        Call<ExtendedRoot<VPPAttributes>> call = vaccinationsPointsAPI.getAllReports();

        try {
            ExtendedRoot<VPPAttributes> response = call.execute().body();
            pointReport = Objects
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
    public List<VPPReport> getAllPointReports() {
        return pointReport;
    }

    @Override
    public Optional<VPPReport> getReportByPoint(String point) {
        return pointReport.stream().filter(vppReport -> vppReport.getName().equals(point)).findFirst();
    }
}
