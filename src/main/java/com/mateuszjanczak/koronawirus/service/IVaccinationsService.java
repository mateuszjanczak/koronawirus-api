package com.mateuszjanczak.koronawirus.service;

import com.mateuszjanczak.koronawirus.model.vaccinations.VaccinationsReport;

import java.util.List;

public interface IVaccinationsService {
    VaccinationsReport getDailyReport();

    List<VaccinationsReport> getPeriodicReport(String from, String to);
}
