package com.mateuszjanczak.koronawirus.infrastructure.covid.province;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CPAttributes {
    @SerializedName("OBJECTID")
    public int oBJECTID;
    public String jpt_nazwa_;
    @SerializedName("SUM_Confirmed")
    public int sUM_Confirmed;
    @SerializedName("SUM_Deaths")
    public int sUM_Deaths;
    @SerializedName("Nazwa_filter")
    public String nazwa_filter;
    @SerializedName("Populacja")
    public int populacja;
    public int potwierdzone_dzienne;
    public int smiertelne_dzienne;
    @SerializedName("POTWIERDZONE_10_TYS_OSOB")
    public double pOTWIERDZONE_10_TYS_OSOB;
    @SerializedName("ZGONY_COVID")
    public int zGONY_COVID;
    @SerializedName("ZGONY_WSPOLISTNIEJACE")
    public int zGONY_WSPOLISTNIEJACE;
    @SerializedName("KWARANTANNA")
    public int kWARANTANNA;
    @SerializedName("TESTY")
    public int tESTY;
    @SerializedName("TESTY_POZYTYWNE")
    public int tESTY_POZYTYWNE;
    @SerializedName("TESTY_NEGATYWNE")
    public int tESTY_NEGATYWNE;
    @SerializedName("ZLECENIA_POZ")
    public int zLECENIA_POZ;
    @SerializedName("TESTY_POZOSTALE")
    public int tESTY_POZOSTALE;
    @SerializedName("Shape__Area")
    public double shape__Area;
    @SerializedName("Shape__Length")
    public double shape__Length;
    @SerializedName("SUM_Recovered")
    public int sUM_Recovered;
}
