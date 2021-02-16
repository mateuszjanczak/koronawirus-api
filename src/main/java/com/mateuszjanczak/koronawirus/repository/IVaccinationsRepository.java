package com.mateuszjanczak.koronawirus.repository;

import com.mateuszjanczak.koronawirus.model.vaccinations.district.VDReport;
import com.mateuszjanczak.koronawirus.model.vaccinations.global.VGReport;
import com.mateuszjanczak.koronawirus.model.vaccinations.points.VPPReport;
import com.mateuszjanczak.koronawirus.model.vaccinations.province.VPReport;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IVaccinationsRepository {

    VGReport getDailyReport();

    List<VGReport> getPeriodicReport(Date from, Date to);

    List<VPReport> getAllProvinceReports();

    Optional<VPReport> getReportByProvince(String province);

    List<VDReport> getAllDistrictReports();

    Optional<VDReport> getReportByDistrict(String district);

    List<VPPReport> getAllPointReports();

    Optional<VPPReport> getReportByPoint(String point);
}
