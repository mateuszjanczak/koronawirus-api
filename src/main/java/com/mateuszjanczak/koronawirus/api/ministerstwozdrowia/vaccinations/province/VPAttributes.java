package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.vaccinations.province;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VPAttributes {
    @SerializedName("OBJECTID")
    public int oBJECTID;
    public String jpt_nazwa_;
    @SerializedName("Populacja")
    public int populacja;
    @SerializedName("SZCZEPIENIA_SUMA")
    public int sZCZEPIENIA_SUMA;
    @SerializedName("Shape__Area")
    public double shape__Area;
    @SerializedName("Shape__Length")
    public double shape__Length;
    @SerializedName("DAWKA_2_SUMA")
    public int dAWKA_2_SUMA;
    @SerializedName("DAWKA_2_DZIENNIE")
    public int dAWKA_2_DZIENNIE;
    @SerializedName("JPT_KJ_I_2")
    public String jPT_KJ_I_2;
    @SerializedName("SZCZEPIENIA_DZIENNIE")
    public int sZCZEPIENIA_DZIENNIE;
}
