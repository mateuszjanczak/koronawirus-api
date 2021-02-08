package com.mateuszjanczak.koronawirus.service;

import com.mateuszjanczak.koronawirus.model.Report;

import java.util.List;

public interface ICovidService {

    Report getDailyReport();

    List<Report> getPeriodicReport(String from, String to);

}
