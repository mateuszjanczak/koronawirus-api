package com.mateuszjanczak.koronawirus.service.interfaces;

import com.mateuszjanczak.koronawirus.model.tests.TGReport;

import java.util.List;

public interface ITestsService {
    TGReport getDailyReport();

    List<TGReport> getPeriodicReport(String from, String to);
}
