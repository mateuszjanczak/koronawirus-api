package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.covid.province;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CovidProvinceAPI {

    @GET("query?f=json&where=1=1&outFields=*&returnGeometry=false")
    Call<CPRoot> getAllReports();

    @GET("query?f=json&outFields=*&returnGeometry=false")
    Call<CPRoot> getCustomReport(@Query("where") String condition);

}
