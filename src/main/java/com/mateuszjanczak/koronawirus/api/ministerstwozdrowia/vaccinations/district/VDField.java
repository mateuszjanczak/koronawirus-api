package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.vaccinations.district;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VDField {
    public String name;
    public String type;
    public String alias;
    public String sqlType;
    public Object domain;
    public Object defaultValue;
    public int length;
}
