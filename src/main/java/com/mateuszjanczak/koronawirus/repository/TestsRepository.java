package com.mateuszjanczak.koronawirus.repository;

import com.mateuszjanczak.koronawirus.exception.ApiErrorException;
import com.mateuszjanczak.koronawirus.infrastructure.model.Feature;
import com.mateuszjanczak.koronawirus.infrastructure.model.Root;
import com.mateuszjanczak.koronawirus.infrastructure.tests.TGAttributes;
import com.mateuszjanczak.koronawirus.infrastructure.tests.TestsGeneralAPI;
import com.mateuszjanczak.koronawirus.mapper.TestsMapper;
import com.mateuszjanczak.koronawirus.model.tests.TGReport;
import org.springframework.stereotype.Repository;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class TestsRepository implements ITestsRepository, ICache {

    private final TestsGeneralAPI testsGeneralAPI;

    private TGReport dailyReport;
    private List<TGReport> periodicReport;

    public TestsRepository() {
        this.testsGeneralAPI = new Retrofit.Builder()
                .baseUrl("https://services-eu1.arcgis.com/zk7YlClTgerl62BY/ArcGIS/rest/services/global_corona_actual_widok3/FeatureServer/0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(TestsGeneralAPI.class);

        fetchAll();
    }

    @Override
    public void fetchAll() {
        fetchDailyReport();
        fetchPeriodicReport();
    }

    @Override
    public TGReport getDailyReport() {
        return dailyReport;
    }

    private void fetchDailyReport() {
        Call<Root<TGAttributes>> call = testsGeneralAPI.getDailyReport();

        try {
            Root<TGAttributes> response = call.execute().body();
            TGAttributes attributes = Objects.requireNonNull(response).getFeatures().get(0).getAttributes();
            dailyReport = TestsMapper.apply(attributes);
        } catch (IOException | NullPointerException | IndexOutOfBoundsException e) {
            throw new ApiErrorException();
        }
    }

    @Override
    public List<TGReport> getPeriodicReport(Date from, Date to) {
        return periodicReport;
    }

    private void fetchPeriodicReport() {

        String condition = "1=1";
        Call<Root<TGAttributes>> call = testsGeneralAPI.getCustomReport(condition);

        try {
            Root<TGAttributes> response = call.execute().body();
            periodicReport = Objects
                    .requireNonNull(response)
                    .getFeatures()
                    .stream()
                    .map(Feature::getAttributes)
                    .map(TestsMapper::apply)
                    .collect(Collectors.toList());
        } catch (IOException | NullPointerException e) {
            throw new ApiErrorException();
        }
    }
}
