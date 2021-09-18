package com.mateuszjanczak.koronawirus.infrastructure.tests;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TGAttributes {
    @SerializedName("OBJECTID")
    public int objectid;
    @SerializedName("Data")
    public long data;
    @SerializedName("ZAKAZENIA_DZIENNE")
    public int zakazeniaDzienne;
    @SerializedName("ZGONY_DZIENNE")
    public int zgonyDzienne;
    @SerializedName("ZGONY_COVID")
    public int zgonyCovid;
    @SerializedName("ZGONY_WSPOLISTNIEJACE")
    public int zgonyWspolistniejace;
    @SerializedName("KWARANTANNA")
    public int kwarantanna;
    @SerializedName("TESTY")
    public int testy;
    @SerializedName("TESTY_POZYTYWNE")
    public int testyPozytywne;
    @SerializedName("ZLECENIA_POZ")
    public int zleceniaPoz;
    @SerializedName("LICZBA_OZDROWIENCOW")
    public int liczbaOzdrowiencow;
    @SerializedName("AKTUALNE_ZAKAZENIA")
    public int aktualneZakazenia;
    @SerializedName("DATA_SHOW")
    public String dataShow;
    @SerializedName("LICZBA_ZGONOW")
    public int liczbaZgonow;
    @SerializedName("WSZYSCY_OZDROWIENCY")
    public int wszyscyOzdrowiency;
    @SerializedName("LICZBA_ZAKAZEN")
    public int liczbaZakazen;
}
