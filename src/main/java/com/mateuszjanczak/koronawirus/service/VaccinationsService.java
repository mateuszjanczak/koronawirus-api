package com.mateuszjanczak.koronawirus.service;

import com.mateuszjanczak.koronawirus.exception.BadDateFormatException;
import com.mateuszjanczak.koronawirus.exception.BadDistrictNameException;
import com.mateuszjanczak.koronawirus.exception.BadPointNameException;
import com.mateuszjanczak.koronawirus.exception.BadProvinceNameException;
import com.mateuszjanczak.koronawirus.model.vaccinations.district.VDReport;
import com.mateuszjanczak.koronawirus.model.vaccinations.global.VGReport;
import com.mateuszjanczak.koronawirus.model.vaccinations.points.VPPReport;
import com.mateuszjanczak.koronawirus.model.vaccinations.province.VPReport;
import com.mateuszjanczak.koronawirus.repository.IVaccinationsRepository;
import com.mateuszjanczak.koronawirus.service.interfaces.IVaccinationsService;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Service
public class VaccinationsService implements IVaccinationsService {

    private final IVaccinationsRepository vaccinationsRepository;

    public VaccinationsService(IVaccinationsRepository vaccinationsRepository) {
        this.vaccinationsRepository = vaccinationsRepository;
    }

    @Override
    public VGReport getDailyReport() {
        return vaccinationsRepository.getDailyReport();
    }

    @Override
    public List<VGReport> getPeriodicReport(String from, String to) {
        String[] acceptedFormats = {"yyyy-MM-dd", "yyyy-MM-dd HH:mm"};

        Date fromDate;
        Date toDate;
        try {
            fromDate = DateUtils.parseDate(from, acceptedFormats);
            toDate = DateUtils.parseDate(to, acceptedFormats);
        } catch (ParseException e) {
            throw new BadDateFormatException();
        }
        return vaccinationsRepository.getPeriodicReport(fromDate, toDate);
    }

    @Override
    public List<VPReport> getAllProvinceReports() {
        return vaccinationsRepository.getAllProvinceReports();
    }

    @Override
    public VPReport getReportByProvince(String province) {
        return vaccinationsRepository.getReportByProvince(province).orElseThrow(BadProvinceNameException::new);
    }

    @Override
    public List<VDReport> getAllDistrictReports() {
        return vaccinationsRepository.getAllDistrictReports();
    }

    @Override
    public VDReport getReportByDistrict(String district) {
        return vaccinationsRepository.getReportByDistrict(district).orElseThrow(BadDistrictNameException::new);
    }

    @Override
    public List<VPPReport> getAllPointsReports() {
        return vaccinationsRepository.getAllPointReports();
    }

    @Override
    public VPPReport getReportByPoint(String point) {
        return vaccinationsRepository.getReportByPoint(point).orElseThrow(BadPointNameException::new);
    }
}
