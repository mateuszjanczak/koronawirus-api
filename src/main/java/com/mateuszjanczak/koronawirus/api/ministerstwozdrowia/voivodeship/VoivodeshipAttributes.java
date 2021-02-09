package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.voivodeship;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VoivodeshipAttributes {
    @SerializedName("OBJECTID")
    private int objectid;

    @SerializedName("jpt_nazwa_")
    private String jpt_nazwa_;

    @SerializedName("SUM_Confirmed")
    private int sum_confirmed;

    @SerializedName("SUM_Deaths")
    private int sum_deaths;

    @SerializedName("Nazwa_filter")
    private String nazwa_filter;

    @SerializedName("Populacja")
    private int populacja;

    @SerializedName("potwierdzone_dzienne")
    private int potwierdzone_dzienne;

    @SerializedName("smiertelne_dzienne")
    private int smiertelne_dzienne;

    @SerializedName("POTWIERDZONE_10_TYS_OSOB")
    private Double potwierdzone_10_tys_osob;

    @SerializedName("ZGONY_COVID")
    private int zgony_covid;

    @SerializedName("ZGONY_WSPOLISTNIEJACE")
    private int zgony_wspolistniejace;

    @SerializedName("KWARANTANNA")
    private int kwarantanna;

    @SerializedName("TESTY")
    private int testy;

    @SerializedName("TESTY_POZYTYWNE")
    private int testy_pozytywne;

    @SerializedName("TESTY_NEGATYWNE")
    private int testy_negatywne;

    @SerializedName("ZLECENIA_POZ")
    private int zlecenia_poz;

    @SerializedName("TESTY_POZOSTALE")
    private int testy_pozostale;

    @SerializedName("Shape__Area")
    private Double shape__area;

    @SerializedName("Shape__Length")
    private Double shape__length;

    @SerializedName("SUM_Recovered")
    private int sum_recovered;
}
