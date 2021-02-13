package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.vaccinations.general;

import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.model.Root;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface VaccinationsGeneralAPI {
    @GET("query?f=json&where=1=1&outFields=*&returnGeometry=false&orderByFields=objectid%20desc&resultRecordCount=1")
    Call<Root<VGAttributes>> getDailyReport();

    @GET("query?f=json&outFields=*&returnGeometry=false")
    Call<Root<VGAttributes>> getCustomReport(@Query("where") String condition);
}
