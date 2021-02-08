package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.model;

import lombok.Data;

@Data
public class Field {
    public String name;
    public String type;
    public String alias;
    public String sqlType;
    public Object domain;
    public Object defaultValue;
    public int length;
}
