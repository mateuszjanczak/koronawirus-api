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

    VPReport getReportByProvince(String name);

    List<VDReport> getAllDistrictReports();

    VDReport getReportByDistrict(String name);

    List<VPPReport> getAllPointsReports();

    VPPReport getReportByName(String name);
}
