package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.vaccinations.province;

import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.model.ExtendedRoot;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface VaccinationsProvinceAPI {

    @GET("query?f=json&where=1=1&outFields=*&returnGeometry=false")
    Call<ExtendedRoot<VPAttributes>> getAllReports();

    @GET("query?f=json&outFields=*&returnGeometry=false")
    Call<ExtendedRoot<VPAttributes>> getCustomReport(@Query("where") String condition);

}
