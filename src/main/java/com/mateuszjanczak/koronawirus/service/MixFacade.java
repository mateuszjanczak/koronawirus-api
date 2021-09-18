package com.mateuszjanczak.koronawirus.service;

import com.mateuszjanczak.koronawirus.exception.BadDateFormatException;
import com.mateuszjanczak.koronawirus.exception.IncompleteDataException;
import com.mateuszjanczak.koronawirus.mapper.MixMapper;
import com.mateuszjanczak.koronawirus.model.covid.global.CGReport;
import com.mateuszjanczak.koronawirus.model.mix.global.MGReport;
import com.mateuszjanczak.koronawirus.model.tests.TGReport;
import com.mateuszjanczak.koronawirus.model.vaccinations.global.VGReport;
import com.mateuszjanczak.koronawirus.repository.ICovidRepository;
import com.mateuszjanczak.koronawirus.repository.ITestsRepository;
import com.mateuszjanczak.koronawirus.repository.IVaccinationsRepository;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;

@Service
public class MixFacade {

    private final ICovidRepository covidRepository;
    private final IVaccinationsRepository vaccinationsRepository;
    private final ITestsRepository testsRepository;

    public MixFacade(ICovidRepository covidRepository, IVaccinationsRepository vaccinationsRepository, ITestsRepository testsRepository) {
        this.covidRepository = covidRepository;
        this.vaccinationsRepository = vaccinationsRepository;
        this.testsRepository = testsRepository;
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
        List<TGReport> tgReportList = testsRepository.getPeriodicReport(fromDate, toDate);

        List<MGReport> mgReportList = new ArrayList<>();

        cgReportList.forEach(cgReport -> {
            Date nearestDate = DateUtils.round(cgReport.getReportDate(), Calendar.DAY_OF_MONTH);
            Optional<VGReport> vgReport = vgReportList.stream().filter(report -> nearestDate.equals(DateUtils.round(report.getReportDate(), Calendar.DAY_OF_MONTH))).findFirst();
            Optional<TGReport> tgReport = tgReportList.stream().filter(report -> nearestDate.equals(DateUtils.round(report.getReportDate(), Calendar.DAY_OF_MONTH))).findFirst();
            if (vgReport.isPresent() && tgReport.isPresent())
                mgReportList.add(MixMapper.apply(cgReport, vgReport.get(), tgReport.get()));
        });

        return mgReportList;
    }

    public MGReport getDailyReport() {
        CGReport cgReport = covidRepository.getDailyReport();
        VGReport vgReport = vaccinationsRepository.getDailyReport();
        TGReport tgReport = testsRepository.getDailyReport();

        Date cgReportDate = DateUtils.round(cgReport.getReportDate(), Calendar.DAY_OF_MONTH);
        Date vgReportDate = DateUtils.round(cgReport.getReportDate(), Calendar.DAY_OF_MONTH);
        Date tgReportDate = DateUtils.round(cgReport.getReportDate(), Calendar.DAY_OF_MONTH);

        if (cgReportDate.equals(tgReportDate) && tgReportDate.equals(vgReportDate))
            return MixMapper.apply(cgReport, vgReport, tgReport);

        throw new IncompleteDataException();
    }
}
