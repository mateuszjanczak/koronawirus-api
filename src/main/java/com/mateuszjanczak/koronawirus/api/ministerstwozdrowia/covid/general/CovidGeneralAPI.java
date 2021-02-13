package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.covid.general;

import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.model.Root;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CovidGeneralAPI {
    @GET("query?f=json&where=1=1&outFields=*&returnGeometry=false&orderByFields=objectid%20desc&resultRecordCount=1")
    Call<Root<CGAttributes>> getDailyReport();

    @GET("query?f=json&outFields=*&returnGeometry=false")
    Call<Root<CGAttributes>> getCustomReport(@Query("where") String condition);
}
