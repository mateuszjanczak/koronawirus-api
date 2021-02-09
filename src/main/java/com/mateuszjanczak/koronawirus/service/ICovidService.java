package com.mateuszjanczak.koronawirus.service;

import com.mateuszjanczak.koronawirus.model.covid.CovidReport;
import com.mateuszjanczak.koronawirus.model.voivodeship.VoivodeshipReport;

import java.util.List;

public interface ICovidService {

    CovidReport getDailyReport();

    List<CovidReport> getPeriodicReport(String from, String to);

    VoivodeshipReport getReportByVoivodeship(String voivodeship);

    List<VoivodeshipReport> getAllVoivodeshipReports();

}
