package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.vaccinations.district;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VDAttributes {
    @SerializedName("OBJECTID")
    public int oBJECTID;
    @SerializedName("JPT_NAZWA_")
    public String jPT_NAZWA_;
    @SerializedName("JPT_KJ_I_1")
    public String jPT_KJ_I_1;
    @SerializedName("JPT_KJ_I_2")
    public String jPT_KJ_I_2;
    @SerializedName("POPULACJA")
    public int pOPULACJA;
    @SerializedName("Shape__Area")
    public double shape__Area;
    @SerializedName("Shape__Length")
    public double shape__Length;
    @SerializedName("SZCZEPIENIA_SUMA")
    public int sZCZEPIENIA_SUMA;
    @SerializedName("SZCZEPIENIA_DZIENNIE")
    public int sZCZEPIENIA_DZIENNIE;
    @SerializedName("DAWKA_2_SUMA")
    public int dAWKA_2_SUMA;
    @SerializedName("DAWKA_2_DZIENNIE")
    public int dAWKA_2_DZIENNIE;
}
