package com.mateuszjanczak.koronawirus.api.ministerstwozdrowia.model;

public class Feature<T> {
    public T attributes;

    public Feature() {
    }

    public Feature(T attributes) {
        this.attributes = attributes;
    }

    public T getAttributes() {
        return attributes;
    }

    public void setAttributes(T attributes) {
        this.attributes = attributes;
    }
}
