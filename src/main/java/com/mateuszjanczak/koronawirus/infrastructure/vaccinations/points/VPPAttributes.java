package com.mateuszjanczak.koronawirus.infrastructure.vaccinations.points;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VPPAttributes {
    @SerializedName("OBJECTID")
    public int oBJECTID;
    @SerializedName("X")
    public double x;
    @SerializedName("Y")
    public double y;
    @SerializedName("NAZWA")
    public String nAZWA;
    @SerializedName("ADRES")
    public String aDRES;
    @SerializedName("NAZWA_KROTKA")
    public String nAZWA_KROTKA;
    @SerializedName("MIEJSCOWOSC")
    public String mIEJSCOWOSC;
    @SerializedName("ODDZIAL_NFZ")
    public String oDDZIAL_NFZ;
    @SerializedName("TELEFON")
    public String tELEFON;
    @SerializedName("ADRES_E_MAIL")
    public String aDRES_E_MAIL;
    @SerializedName("SZCZEPIENIA_SUMA")
    public int sZCZEPIENIA_SUMA;
    @SerializedName("SZCZEPIENIA_DZIENNE")
    public int sZCZEPIENIA_DZIENNE;
}