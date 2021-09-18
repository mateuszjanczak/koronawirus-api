package com.mateuszjanczak.koronawirus.repository;

import com.mateuszjanczak.koronawirus.model.tests.TGReport;

import java.util.Date;
import java.util.List;

public interface ITestsRepository {
    TGReport getDailyReport();

    List<TGReport> getPeriodicReport(Date from, Date to);
}
