package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.covid;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CovidAttributes {

    @SerializedName("OBJECTID")
    public int objectid;

    @SerializedName("Data")
    public long data;

    @SerializedName("LICZBA_ZAKAZEN")
    public int liczba_zakazen;

    @SerializedName("LICZBA_ZGONOW")
    public int liczba_zgonow;

    @SerializedName("ZGONY_KOBIETY")
    public int zgony_kobiety;

    @SerializedName("ZGONY_MEZCZYZNI")
    public int zgony_mezczyzni;

    @SerializedName("ZGONY0_10")
    public int zgony0_10;

    @SerializedName("ZGONY11_20")
    public int zgony11_20;

    @SerializedName("ZGONY21_30")
    public int zgony21_30;

    @SerializedName("ZGONY31_40")
    public int zgony31_40;

    @SerializedName("ZGONY41_50")
    public int zgony41_50;

    @SerializedName("ZGONY51_60")
    public int zgony51_60;

    @SerializedName("ZGONY61_70")
    public int zgony61_70;

    @SerializedName("ZGONY71_80")
    public int zgony70_71;

    @SerializedName("ZGONY81_")
    public int zgony81_;

    @SerializedName("ZAKAZENIA_DZIENNE")
    public int zakazenia_dzienne;

    @SerializedName("ZGONY_DZIENNE")
    public int zgony_dzienne;

    @SerializedName("LICZBA_OZDROWIENCOW")
    public int liczba_ozdrowiencow;

}
