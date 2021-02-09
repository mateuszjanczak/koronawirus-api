package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.covid.district;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CDAttributes {
    @SerializedName("OBJECTID")
    public int oBJECTID;
    @SerializedName("JPT_NAZWA_")
    public String jPT_NAZWA_;
    @SerializedName("JPT_KJ_I_1")
    public String jPT_KJ_I_1;
    @SerializedName("JPT_KJ_I_2")
    public String jPT_KJ_I_2;
    @SerializedName("POTWIERDZONE_DZIENNE")
    public int pOTWIERDZONE_DZIENNE;
    @SerializedName("POTWIERDZONE_10_TYS_OSOB")
    public double pOTWIERDZONE_10_TYS_OSOB;
    @SerializedName("ZGONY")
    public int zGONY;
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
    @SerializedName("POPULACJA")
    public int pOPULACJA;
    @SerializedName("Shape__Area")
    public double shape__Area;
    @SerializedName("Shape__Length")
    public double shape__Length;
    @SerializedName("LICZBA_OZDROWIENCOW")
    public Object lICZBA_OZDROWIENCOW;
    @SerializedName("WOJEWODZTWO")
    public String wOJEWODZTWO;
}
