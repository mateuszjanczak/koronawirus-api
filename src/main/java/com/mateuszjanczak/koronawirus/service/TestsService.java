package com.mateuszjanczak.koronawirus.service;

import com.mateuszjanczak.koronawirus.exception.BadDateFormatException;
import com.mateuszjanczak.koronawirus.model.tests.TGReport;
import com.mateuszjanczak.koronawirus.repository.ITestsRepository;
import com.mateuszjanczak.koronawirus.service.interfaces.ITestsService;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Service
public class TestsService implements ITestsService {

    private final ITestsRepository testsRepository;

    public TestsService(ITestsRepository testsRepository) {
        this.testsRepository = testsRepository;
    }

    @Override
    public TGReport getDailyReport() {
        return testsRepository.getDailyReport();
    }

    @Override
    public List<TGReport> getPeriodicReport(String from, String to) {
        String[] acceptedFormats = {"yyyy-MM-dd", "yyyy-MM-dd HH:mm"};
        Date fromDate;
        Date toDate;

        try {
            fromDate = DateUtils.parseDate(from, acceptedFormats);
            toDate = DateUtils.parseDate(to, acceptedFormats);
        } catch (ParseException e) {
            throw new BadDateFormatException();
        }

        return testsRepository.getPeriodicReport(fromDate, toDate);
    }
}
