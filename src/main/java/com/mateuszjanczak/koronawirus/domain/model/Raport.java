package com.mateuszjanczak.koronawirus.domain.model;

public class Raport {
    public int id;
    public String wojewodztwo;
    public int zarazeni;
    public int martwi;

    public Raport() {
    }

    public Raport(int id, String wojewodztwo, int zarazeni, int martwi) {
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
