package com.mateuszjanczak.koronawirus.service;

import com.mateuszjanczak.koronawirus.domain.model.Raport;
import java.util.ArrayList;

public interface KoronawirusService {

    ArrayList<Raport> getAll();
    Raport getById(int id);
    Raport getByWojewodztwo(String wojewodztwo);

}
