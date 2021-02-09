package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia;

import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.covid.CovidRoot;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CovidAPI {
    @GET("query?f=json&outFields=*&where=Data%20BETWEEN%20(CURRENT_TIMESTAMP%20-%20INTERVAL%20%2724%27%20HOUR)%20AND%20CURRENT_TIMESTAMP")
    Call<CovidRoot> getDailyReport();

    @GET("query?f=json&outFields=*")
    Call<CovidRoot> getCustomReport(@Query("where") String condition);
}
