package com.mateuszjanczak.koronawirus.service;

import com.mateuszjanczak.koronawirus.model.Report;

import java.util.List;

public interface KoronawirusService {

    List<Report> getAll();
    Report getById(int id);
    Report getByWojewodztwo(String wojewodztwo);

}
