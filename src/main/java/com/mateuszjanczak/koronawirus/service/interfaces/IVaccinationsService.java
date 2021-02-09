package com.mateuszjanczak.koronawirus.service.interfaces;

import com.mateuszjanczak.koronawirus.model.vaccinations.global.VGReport;
import com.mateuszjanczak.koronawirus.model.vaccinations.province.VPReport;

import java.util.List;

public interface IVaccinationsService {
    VGReport getDailyReport();

    List<VGReport> getPeriodicReport(String from, String to);

    List<VPReport> getAllProvinceReports();

    VPReport getReportByProvince(String name);
}
