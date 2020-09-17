package com.mateuszjanczak.koronawirus.model;

import com.google.gson.annotations.SerializedName;

public class Report {

    private int id;

    @SerializedName("Województwo")
    private String wojewodztwo;

    @SerializedName("Liczba")
    private int zarazeni;

    @SerializedName("Liczbazgonów")
    private int martwi;

    @Override
    public String toString() {
        return "Raport{" +
                "wojewodztwo='" + wojewodztwo + '\'' +
                ", zarazeni='" + zarazeni + '\'' +
                ", martwi='" + martwi + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public Report() {
    }

    public Report(int id, String wojewodztwo, int zarazeni, int martwi) {
        this.id = id;
        this.wojewodztwo = wojewodztwo;
        this.zarazeni = zarazeni;
        this.martwi = martwi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWojewodztwo() {
        return wojewodztwo;
    }

    public void setWojewodztwo(String wojewodztwo) {
        this.wojewodztwo = wojewodztwo;
    }

    public int getZarazeni() {
        return zarazeni;
    }

    public void setZarazeni(int zarazeni) {
        this.zarazeni = zarazeni;
    }

    public int getMartwi() {
        return martwi;
    }

    public void setMartwi(int martwi) {
        this.martwi = martwi;
    }
}
