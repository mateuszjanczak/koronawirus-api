package com.mateuszjanczak.koronawirus.infrastructure.vaccinations.province;

import com.mateuszjanczak.koronawirus.infrastructure.model.ExtendedRoot;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface VaccinationsProvinceAPI {
    @GET("query?f=json&where=1=1&outFields=*&returnGeometry=false")
    Call<ExtendedRoot<VPAttributes>> getAllReports();

    @GET("query?f=json&outFields=*&returnGeometry=false")
    Call<ExtendedRoot<VPAttributes>> getCustomReport(@Query("where") String condition);
}
