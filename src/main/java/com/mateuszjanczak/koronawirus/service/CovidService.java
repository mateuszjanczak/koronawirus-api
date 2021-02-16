package com.mateuszjanczak.koronawirus.service;

import com.mateuszjanczak.koronawirus.exception.BadDateFormatException;
import com.mateuszjanczak.koronawirus.exception.BadDistrictNameException;
import com.mateuszjanczak.koronawirus.exception.BadProvinceNameException;
import com.mateuszjanczak.koronawirus.model.covid.district.CDReport;
import com.mateuszjanczak.koronawirus.model.covid.global.CGReport;
import com.mateuszjanczak.koronawirus.model.covid.province.CPReport;
import com.mateuszjanczak.koronawirus.repository.ICovidRepository;
import com.mateuszjanczak.koronawirus.service.interfaces.ICovidService;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Service
public class CovidService implements ICovidService {

    private final ICovidRepository covidRepository;

    public CovidService(ICovidRepository covidRepository) {
        this.covidRepository = covidRepository;
    }

    @Override
    public CGReport getDailyReport() {
        return covidRepository.getDailyReport();
    }

    @Override
    public List<CGReport> getPeriodicReport(String from, String to) {

        String[] acceptedFormats = {"yyyy-MM-dd", "yyyy-MM-dd HH:mm"};
        Date fromDate;
        Date toDate;

        try {
            fromDate = DateUtils.parseDate(from, acceptedFormats);
            toDate = DateUtils.parseDate(to, acceptedFormats);
        } catch (ParseException e) {
            throw new BadDateFormatException();
        }

        return covidRepository.getPeriodicReport(fromDate, toDate);
    }

    @Override
    public CPReport getReportByProvince(String province) {
        return covidRepository.getReportByProvince(province).orElseThrow(BadProvinceNameException::new);
    }

    @Override
    public List<CPReport> getAllProvinceReports() {
        return covidRepository.getAllProvinceReports();
    }

    @Override
    public CDReport getReportByDistrict(String district) {
        return covidRepository.getReportByDistrict(district).orElseThrow(BadDistrictNameException::new);
    }

    @Override
    public List<CDReport> getAllDistrictReports() {
        return covidRepository.getAllDistrictReports();
    }
}
