package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.covid.general;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CGAttributes {
    @SerializedName("OBJECTID")
    public int oBJECTID;
    @SerializedName("Data")
    public Long data;
    @SerializedName("LICZBA_ZAKAZEN")
    public int lICZBA_ZAKAZEN;
    @SerializedName("LICZBA_ZGONOW")
    public int lICZBA_ZGONOW;
    @SerializedName("ZGONY_KOBIETY")
    public int zGONY_KOBIETY;
    @SerializedName("ZGONY_MEZCZYZNI")
    public int zGONY_MEZCZYZNI;
    @SerializedName("ZGONY0_10")
    public int zGONY0_10;
    @SerializedName("ZGONY11_20")
    public int zGONY11_20;
    @SerializedName("ZGONY21_30")
    public int zGONY21_30;
    @SerializedName("ZGONY31_40")
    public int zGONY31_40;
    @SerializedName("ZGONY41_50")
    public int zGONY41_50;
    @SerializedName("ZGONY51_60")
    public int zGONY51_60;
    @SerializedName("ZGONY61_70")
    public int zGONY61_70;
    @SerializedName("ZGONY71_80")
    public int zGONY71_80;
    @SerializedName("ZGONY81_")
    public int zGONY81_;
    @SerializedName("ZAKAZENIA_DZIENNE")
    public int zAKAZENIA_DZIENNE;
    @SerializedName("ZGONY_DZIENNE")
    public int zGONY_DZIENNE;
    @SerializedName("LICZBA_OZDROWIENCOW")
    public int lICZBA_OZDROWIENCOW;
}
