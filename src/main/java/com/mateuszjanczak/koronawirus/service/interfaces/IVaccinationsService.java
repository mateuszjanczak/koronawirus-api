package com.mateuszjanczak.koronawirus.service.interfaces;

import com.mateuszjanczak.koronawirus.model.vaccinations.district.VDReport;
import com.mateuszjanczak.koronawirus.model.vaccinations.global.VGReport;
import com.mateuszjanczak.koronawirus.model.vaccinations.points.VPPReport;
import com.mateuszjanczak.koronawirus.model.vaccinations.province.VPReport;

import java.util.List;

public interface IVaccinationsService {
    VGReport getDailyReport();

    List<VGReport> getPeriodicReport(String from, String to);

    List<VPReport> getAllProvinceReports();

    VPReport getReportByProvince(String province);

    List<VDReport> getAllDistrictReports();

    VDReport getReportByDistrict(String district);

    List<VPPReport> getAllPointsReports();

    VPPReport getReportByPoint(String point);
}
