package com.mateuszjanczak.koronawirus.service.interfaces;

import com.mateuszjanczak.koronawirus.model.covid.district.CDReport;
import com.mateuszjanczak.koronawirus.model.covid.global.CGReport;
import com.mateuszjanczak.koronawirus.model.covid.province.CPReport;
import com.mateuszjanczak.koronawirus.model.vaccinations.district.VDReport;

import java.util.List;

public interface ICovidService {

    CGReport getDailyReport();

    List<CGReport> getPeriodicReport(String from, String to);

    CPReport getReportByProvince(String voivodeship);

    List<CPReport> getAllProvinceReports();

    List<CDReport> getAllDistrictReports();

    CDReport getReportByDistrict(String name);
}
