package com.mateuszjanczak.koronawirus.service;

import com.mateuszjanczak.koronawirus.model.covid.CovidReport;

import java.util.List;

public interface ICovidService {

    CovidReport getDailyReport();

    List<CovidReport> getPeriodicReport(String from, String to);

}
