package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia;

import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.model.MZRoot;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MZAPI {

    @GET("query?f=json&where=Data%20BETWEEN%20(CURRENT_TIMESTAMP%20-%20INTERVAL%20%2724%27%20HOUR)%20AND%20CURRENT_TIMESTAMP&outFields=*&")
    Call<MZRoot> getDailyReport();
}
