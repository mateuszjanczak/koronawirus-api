package com.mateuszjanczak.koronawirus.infrastructure.vaccinations.district;

import com.mateuszjanczak.koronawirus.infrastructure.model.ExtendedRoot;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface VaccinationsDistrictAPI {
    @GET("query?f=json&where=1=1&outFields=*&returnGeometry=false")
    Call<ExtendedRoot<VDAttributes>> getAllReports();

    @GET("query?f=json&outFields=*&returnGeometry=false")
    Call<ExtendedRoot<VDAttributes>> getCustomReport(@Query("where") String condition);
}
