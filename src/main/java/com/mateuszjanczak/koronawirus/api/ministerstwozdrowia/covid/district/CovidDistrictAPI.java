package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.covid.district;

import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.model.ExtendedRoot;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CovidDistrictAPI {
    @GET("query?f=json&where=1=1&outFields=*&returnGeometry=false")
    Call<ExtendedRoot<CDAttributes>> getAllReports();

    @GET("query?f=json&outFields=*&returnGeometry=false")
    Call<ExtendedRoot<CDAttributes>> getCustomReport(@Query("where") String condition);
}
