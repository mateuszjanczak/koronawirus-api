package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.covid.general;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CGField {
    public String name;
    public String type;
    public String alias;
    public String sqlType;
    public Object domain;
    public Object defaultValue;
    public int length;
}
