package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia;

import com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.voivodeship.VoivodeshipRoot;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface VoivodeshipAPI {

    @GET("query?f=json&where=1=1&outFields=*&returnGeometry=false")
    Call<VoivodeshipRoot> getAllReports();

    @GET("query?f=json&outFields=*&returnGeometry=false")
    Call<VoivodeshipRoot> getCustomReport(@Query("where") String condition);

}
