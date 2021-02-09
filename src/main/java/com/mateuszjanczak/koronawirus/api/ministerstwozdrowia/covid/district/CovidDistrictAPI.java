package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.covid.district;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CovidDistrictAPI {
    @GET("query?f=json&where=1=1&outFields=*&returnGeometry=false")
    Call<CDRoot> getAllReports();

    @GET("query?f=json&outFields=*&returnGeometry=false")
    Call<CDRoot> getCustomReport(@Query("where") String condition);
}
