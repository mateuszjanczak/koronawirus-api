package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia;

import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.model.MZRoot;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MZAPI {

    @GET("query?f=json&outFields=*&where=Data%20BETWEEN%20(CURRENT_TIMESTAMP%20-%20INTERVAL%20%2724%27%20HOUR)%20AND%20CURRENT_TIMESTAMP")
    Call<MZRoot> getDailyReport();

    @GET("query?f=json&outFields=*")
    Call<MZRoot> getCustomReport(@Query("where") String condition);

}
