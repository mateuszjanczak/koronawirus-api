package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.vaccinations.points;

import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.model.ExtendedRoot;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface VaccinationsPointsAPI {
    @GET("query?f=json&where=1=1&outFields=*&returnGeometry=false")
    Call<ExtendedRoot<VPPAttributes>> getAllReports();

    @GET("query?f=json&outFields=*&returnGeometry=false")
    Call<ExtendedRoot<VPPAttributes>> getCustomReport(@Query("where") String condition);
}
