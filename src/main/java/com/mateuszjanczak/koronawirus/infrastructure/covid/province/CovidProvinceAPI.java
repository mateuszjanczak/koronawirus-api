package com.mateuszjanczak.koronawirus.infrastructure.covid.province;

import com.mateuszjanczak.koronawirus.infrastructure.model.ExtendedRoot;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CovidProvinceAPI {

    @GET("query?f=json&where=1=1&outFields=*&returnGeometry=false")
    Call<ExtendedRoot<CPAttributes>> getAllReports();

    @GET("query?f=json&outFields=*&returnGeometry=false")
    Call<ExtendedRoot<CPAttributes>> getCustomReport(@Query("where") String condition);

}
