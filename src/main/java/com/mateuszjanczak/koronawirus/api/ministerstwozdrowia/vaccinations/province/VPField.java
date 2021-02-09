package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.vaccinations.province;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VPField {
    public String name;
    public String type;
    public String alias;
    public String sqlType;
    public Object domain;
    public Object defaultValue;
    public int length;
}
