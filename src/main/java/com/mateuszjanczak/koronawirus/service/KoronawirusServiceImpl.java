package com.mateuszjanczak.koronawirus.service;

import com.mateuszjanczak.koronawirus.domain.model.Raport;
import com.mateuszjanczak.koronawirus.webscraper.KoronawirusWebscraper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class KoronawirusServiceImpl implements KoronawirusService {

    ArrayList<Raport> raporty;

    public KoronawirusServiceImpl() {
        raporty = KoronawirusWebscraper.Scrap();
    }

    @Override
    public ArrayList<Raport> getAll() {
        return raporty;
    }

    @Override
    public Raport getById(int id) {
        for (Raport raport : raporty) {
            if(raport.getId() == id) {
                return raport;
            }
        }
        return null;
    }

    @Override
    public Raport getByWojewodztwo(String wojewodztwo) {
        HashMap<String, String> wojewodztwa = new HashMap<>();
        wojewodztwa.put("polska", "Cała polska");
        wojewodztwa.put("dolnoslaskie", "dolnośląskie");
        wojewodztwa.put("kujawsko-pomorskie", "kujawsko-pomorskie");
        wojewodztwa.put("lubelskie", "lubelskie");
        wojewodztwa.put("lubuskie", "lubuskie");
        wojewodztwa.put("lodzkie", "łódzkie");
        wojewodztwa.put("malopolskie", "małopolskie");
        wojewodztwa.put("mazowieckie", "mazowieckie");
        wojewodztwa.put("opolskie", "opolskie");
        wojewodztwa.put("podkarpackie", "podkarpackie");
        wojewodztwa.put("podlaskie", "podlaskie");
        wojewodztwa.put("pomorskie", "pomorskie");
        wojewodztwa.put("slaskie", "śląskie");
        wojewodztwa.put("swietokrzyskie", "świętokrzyskie");
        wojewodztwa.put("warminsko-mazurskie", "warmińsko-mazurskie");
        wojewodztwa.put("wielkopolskie", "wielkopolskie");
        wojewodztwa.put("zachodniopomorskie", "zachodniopomorskie");

        for (Raport raport : raporty) {
            if(raport.getWojewodztwo().equals(wojewodztwa.get(wojewodztwo))) {
                return raport;
            }
        }
        return null;
    }
}
