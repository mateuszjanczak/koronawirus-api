package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.vaccinations.district;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface VaccinationsDistrictAPI {
    @GET("query?f=json&where=1=1&outFields=*&returnGeometry=false")
    Call<VDRoot> getAllReports();

    @GET("query?f=json&outFields=*&returnGeometry=false")
    Call<VDRoot> getCustomReport(@Query("where") String condition);
}
