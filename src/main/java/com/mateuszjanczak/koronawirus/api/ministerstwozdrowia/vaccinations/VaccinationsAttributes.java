package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.vaccinations;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class VaccinationsAttributes {

    @SerializedName("OBJECTID")
    public Integer objectid;

    @SerializedName("Data")
    public long data;

    @SerializedName("SZCZEPIENIA_SUMA")
    public Integer szczepienia_suma;

    @SerializedName("SZCZEPIENIA_DZIENNIE")
    public Integer szczepienia_dziennie;

    @SerializedName("DAWKA_2_SUMA")
    public Integer dawka_2_suma;

    @SerializedName("DAWKA_2_DZIENNIE")
    public Integer dawka_2_dziennie;

    @SerializedName("DATA_SHOW")
    public String data_show;

    @SerializedName("ODCZYNY_NIEPOZADANE")
    public Integer odczyny_niepozadane;

    @SerializedName("DAWKI_UTRACONE")
    public Integer dawki_utracone;

    @SerializedName("SZCZEPIENIA_PLEC_NIEUSTALONO")
    public Integer szczepienia_plec_nieustalono;

    @SerializedName("SZCZEPIENIA_KOBIETY")
    public Integer szczepienia_kobiety;

    @SerializedName("SZCZEPIENIA_MEZCZYZNI")
    public Integer szczepienia_mezczyzni;

    @SerializedName("SZCZEPIENIA0_17")
    public Integer szczepienia0_17;

    @SerializedName("SZCZEPIENIA18_30")
    public Integer szczepienia18_30;

    @SerializedName("SZCZEPIENIA31_40")
    public Integer szczepienia31_40;

    @SerializedName("SZCZEPIENIA41_50")
    public Integer szczepienia41_50;

    @SerializedName("SZCZEPIENIA51_60")
    public Integer szczepienia51_60;

    @SerializedName("SZCZEPIENIA61_70")
    public Integer szczepienia61_70;

    @SerializedName("SZCZEPIENIA71_75")
    public Integer szczepienia71_75;

    @SerializedName("SZCZEPIENIA75_")
    public Integer szczepienia75_;

    @SerializedName("SZCZEPIENIA_WIEK_NIEUSTALONO")
    public Integer szczepienia_wiek_nieustalono;

    @SerializedName("STAN_MAGAZYN")
    public Integer stan_magazyn;

    @SerializedName("LICZBA_DAWEK_PUNKTY")
    public Integer liczba_dawek_punkty;

    @SerializedName("DAWKA_1_SUMA")
    public Integer dawka_1_suma;

    @SerializedName("SUMA_DAWEK_POLSKA")
    public Integer suma_dawek_polska;

}