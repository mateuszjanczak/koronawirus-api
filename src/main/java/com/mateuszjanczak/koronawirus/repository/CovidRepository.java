package com.mateuszjanczak.koronawirus.repository;

import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.covid.district.CDAttributes;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.covid.district.CovidDistrictAPI;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.covid.general.CGAttributes;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.covid.general.CovidGeneralAPI;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.covid.province.CPAttributes;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.covid.province.CovidProvinceAPI;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.model.ExtendedRoot;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.model.Feature;
import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.model.Root;
import com.mateuszjanczak.koronawirus.exception.ApiErrorException;
import com.mateuszjanczak.koronawirus.mapper.CovidMapper;
import com.mateuszjanczak.koronawirus.model.covid.district.CDReport;
import com.mateuszjanczak.koronawirus.model.covid.global.CGReport;
import com.mateuszjanczak.koronawirus.model.covid.province.CPReport;
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
public class CovidRepository implements ICovidRepository, ICache {

    private final CovidGeneralAPI covidGeneralAPI;
    private final CovidProvinceAPI covidProvinceAPI;
    private final CovidDistrictAPI covidDistrictAPI;

    private CGReport dailyReport;
    private List<CGReport> periodicReport;
    private List<CPReport> provinceReport;
    private List<CDReport> districtReport;

    public CovidRepository() {
        this.covidGeneralAPI = new Retrofit.Builder()
                .baseUrl("https://services-eu1.arcgis.com/zk7YlClTgerl62BY/ArcGIS/rest/services/global_corona_widok2/FeatureServer/0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CovidGeneralAPI.class);

        this.covidProvinceAPI = new Retrofit.Builder()
                .baseUrl("https://services-eu1.arcgis.com/zk7YlClTgerl62BY/ArcGIS/rest/services/wojewodztwa_corona_widok/FeatureServer/0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CovidProvinceAPI.class);

        this.covidDistrictAPI = new Retrofit.Builder()
                .baseUrl("https://services-eu1.arcgis.com/zk7YlClTgerl62BY/ArcGIS/rest/services/powiaty_corona_widok_woj/FeatureServer/0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CovidDistrictAPI.class);

        fetchAll();
    }

    @Override
    public void fetchAll() {
        fetchDailyReport();
        fetchPeriodicReport();
        fetchAllProvinceReports();
        fetchAllDistrictReports();
    }

    public void fetchDailyReport() {
        Call<Root<CGAttributes>> call = covidGeneralAPI.getDailyReport();

        try {
            Root<CGAttributes> response = call.execute().body();
            CGAttributes attributes = Objects.requireNonNull(response).getFeatures().get(0).getAttributes();
            dailyReport = CovidMapper.apply(attributes);
        } catch (IOException | NullPointerException | IndexOutOfBoundsException e) {
            throw new ApiErrorException();
        }
    }

    @Override
    public CGReport getDailyReport() {
        return dailyReport;
    }

    public void fetchPeriodicReport() {

        String condition = "1=1";
        Call<Root<CGAttributes>> call = covidGeneralAPI.getCustomReport(condition);

        try {
            Root<CGAttributes> response = call.execute().body();
            periodicReport = Objects
                    .requireNonNull(response)
                    .getFeatures()
                    .stream()
                    .map(Feature::getAttributes)
                    .map(CovidMapper::apply)
                    .collect(Collectors.toList());
        } catch (IOException | NullPointerException e) {
            throw new ApiErrorException();
        }
    }

    @Override
    public List<CGReport> getPeriodicReport(Date from, Date to) {
        return periodicReport.stream().filter(cgReport -> cgReport.getReportDate().after(from) && cgReport.getReportDate().before(to)).collect(Collectors.toList());
    }

    public void fetchAllProvinceReports() {

        Call<ExtendedRoot<CPAttributes>> call = covidProvinceAPI.getAllReports();

        try {
            ExtendedRoot<CPAttributes> response = call.execute().body();
            provinceReport = Objects
                    .requireNonNull(response)
                    .getFeatures()
                    .stream()
                    .map(Feature::getAttributes)
                    .map(CovidMapper::apply)
                    .collect(Collectors.toList());
        } catch (IOException | NullPointerException e) {
            throw new ApiErrorException();
        }
    }

    @Override
    public List<CPReport> getAllProvinceReports() {
        return provinceReport;
    }

    @Override
    public Optional<CPReport> getReportByProvince(String province) {
        return provinceReport.stream().filter(cpReport -> cpReport.getProvince().equals(province)).findFirst();
    }

    public void fetchAllDistrictReports() {

        Call<ExtendedRoot<CDAttributes>> call = covidDistrictAPI.getAllReports();

        try {
            ExtendedRoot<CDAttributes> response = call.execute().body();
            districtReport = Objects
                    .requireNonNull(response)
                    .getFeatures()
                    .stream()
                    .map(Feature::getAttributes)
                    .map(CovidMapper::apply)
                    .collect(Collectors.toList());
        } catch (IOException | NullPointerException e) {
            throw new ApiErrorException();
        }
    }

    @Override
    public List<CDReport> getAllDistrictReports() {
        return districtReport;
    }

    @Override
    public Optional<CDReport> getReportByDistrict(String district) {
        return districtReport.stream().filter(cdReport -> cdReport.getDistrict().equals(district)).findFirst();
    }
}
