package com.mateuszjanczak.koronawirus.service;

import com.mateuszjanczak.koronawirus.model.Report;

public interface ICovidService {
    Report getDailyReport();
}
