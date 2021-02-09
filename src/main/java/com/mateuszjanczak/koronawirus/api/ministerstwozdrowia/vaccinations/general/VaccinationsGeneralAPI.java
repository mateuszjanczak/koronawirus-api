package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.vaccinations.general;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface VaccinationsGeneralAPI {
    @GET("query?f=json&outFields=*&where=Data%20BETWEEN%20(CURRENT_TIMESTAMP%20-%20INTERVAL%20%2724%27%20HOUR)%20AND%20CURRENT_TIMESTAMP&returnGeometry=false")
    Call<VGRoot> getDailyReport();

    @GET("query?f=json&outFields=*&returnGeometry=false")
    Call<VGRoot> getCustomReport(@Query("where") String condition);
}
