package com.mateuszjanczak.koronawirus.repository;

import com.mateuszjanczak.koronawirus.model.covid.district.CDReport;
import com.mateuszjanczak.koronawirus.model.covid.global.CGReport;
import com.mateuszjanczak.koronawirus.model.covid.province.CPReport;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ICovidRepository {
    CGReport getDailyReport();

    List<CGReport> getPeriodicReport(Date from, Date to);

    Optional<CPReport> getReportByProvince(String province);

    List<CPReport> getAllProvinceReports();

    List<CDReport> getAllDistrictReports();

    Optional<CDReport> getReportByDistrict(String district);
}
