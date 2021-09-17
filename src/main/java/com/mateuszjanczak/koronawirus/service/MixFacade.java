package com.mateuszjanczak.koronawirus.service;

import com.mateuszjanczak.koronawirus.exception.BadDateFormatException;
import com.mateuszjanczak.koronawirus.mapper.MixMapper;
import com.mateuszjanczak.koronawirus.model.covid.global.CGReport;
import com.mateuszjanczak.koronawirus.model.mix.global.MGReport;
import com.mateuszjanczak.koronawirus.model.vaccinations.global.VGReport;
import com.mateuszjanczak.koronawirus.repository.ICovidRepository;
import com.mateuszjanczak.koronawirus.repository.IVaccinationsRepository;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;

@Service
public class MixFacade {

    private final ICovidRepository covidRepository;
    private final IVaccinationsRepository vaccinationsRepository;

    public MixFacade(ICovidRepository covidRepository, IVaccinationsRepository vaccinationsRepository) {
        this.covidRepository = covidRepository;
        this.vaccinationsRepository = vaccinationsRepository;
    }


    public List<MGReport> getPeriodicReport(String from, String to) {
        String[] acceptedFormats = {"yyyy-MM-dd", "yyyy-MM-dd HH:mm"};
        Date fromDate;
        Date toDate;

        try {
            fromDate = DateUtils.parseDate(from, acceptedFormats);
            toDate = DateUtils.parseDate(to, acceptedFormats);
        } catch (ParseException e) {
            throw new BadDateFormatException();
        }

        List<CGReport> cgReportList = covidRepository.getPeriodicReport(fromDate, toDate);
        List<VGReport> vgReportList = vaccinationsRepository.getPeriodicReport(fromDate, toDate);
        List<MGReport> mgReportList = new ArrayList<>();

        cgReportList.forEach(cgReport -> {
            Date nearestDate = DateUtils.round(cgReport.getReportDate(), Calendar.DAY_OF_MONTH);
            Optional<VGReport> vgReport = vgReportList.stream().filter(report -> nearestDate.equals(DateUtils.round(report.getReportDate(), Calendar.DAY_OF_MONTH))).findFirst();
            vgReport.ifPresent(report -> mgReportList.add(MixMapper.apply(cgReport, report)));
        });

        return mgReportList;
    }

    public MGReport getDailyReport() {
        return MixMapper.apply(covidRepository.getDailyReport(), vaccinationsRepository.getDailyReport());
    }
}
