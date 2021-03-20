package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.vaccinations.general;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VGAttributes {
    @SerializedName("OBJECTID")
    public int oBJECTID;
    @SerializedName("Data")
    public Long data;
    @SerializedName("SZCZEPIENIA_SUMA")
    public int sZCZEPIENIA_SUMA;
    @SerializedName("SZCZEPIENIA_DZIENNIE")
    public int sZCZEPIENIA_DZIENNIE;
    @SerializedName("DAWKA_2_SUMA")
    public int dAWKA_2_SUMA;
    @SerializedName("DAWKA_2_DZIENNIE")
    public int dAWKA_2_DZIENNIE;
    @SerializedName("DATA_SHOW")
    public String dATA_SHOW;
    @SerializedName("ODCZYNY_NIEPOZADANE")
    public int oDCZYNY_NIEPOZADANE;
    @SerializedName("DAWKI_UTRACONE")
    public int dAWKI_UTRACONE;
    @SerializedName("SZCZEPIENIA_PLEC_NIEUSTALONO")
    public int sZCZEPIENIA_PLEC_NIEUSTALONO;
    @SerializedName("SZCZEPIENIA_KOBIETY")
    public int sZCZEPIENIA_KOBIETY;
    @SerializedName("SZCZEPIENIA_MEZCZYZNI")
    public int sZCZEPIENIA_MEZCZYZNI;
    @SerializedName("SZCZEPIENIA0_17")
    public int sZCZEPIENIA0_17;
    @SerializedName("SZCZEPIENIA18_30")
    public int sZCZEPIENIA18_30;
    @SerializedName("SZCZEPIENIA31_40")
    public int sZCZEPIENIA31_40;
    @SerializedName("SZCZEPIENIA41_50")
    public int sZCZEPIENIA41_50;
    @SerializedName("SZCZEPIENIA51_60")
    public int sZCZEPIENIA51_60;
    @SerializedName("SZCZEPIENIA61_70")
    public int sZCZEPIENIA61_70;
    @SerializedName("SZCZEPIENIA71_75")
    public int sZCZEPIENIA71_75;
    @SerializedName("SZCZEPIENIA75_")
    public int sZCZEPIENIA75_;
    @SerializedName("SZCZEPIENIA_WIEK_NIEUSTALONO")
    public int sZCZEPIENIA_WIEK_NIEUSTALONO;
    @SerializedName("STAN_MAGAZYN")
    public int sTAN_MAGAZYN;
    @SerializedName("LICZBA_DAWEK_PUNKTY")
    public int lICZBA_DAWEK_PUNKTY;
    @SerializedName("DAWKA_1_SUMA")
    public int dAWKA_1_SUMA;
    @SerializedName("SUMA_DAWEK_POLSKA")
    public int sUMA_DAWEK_POLSKA;
    @SerializedName("zamowienia_realizacja")
    public int zamowienia_realizacja;
}
