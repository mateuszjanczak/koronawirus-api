package com.mateuszjanczak.koronawirus.web.rest;

import com.mateuszjanczak.koronawirus.model.covid.district.CDReport;
import com.mateuszjanczak.koronawirus.model.covid.global.CGReport;
import com.mateuszjanczak.koronawirus.model.covid.province.CPReport;
import com.mateuszjanczak.koronawirus.service.interfaces.ICovidService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mateuszjanczak.koronawirus.web.rest.TestResource.*;

@RestController
@CrossOrigin
@RequestMapping(COVID_API)
public class CovidResource {

    private final ICovidService covidService;

    public CovidResource(ICovidService covidService) {
        this.covidService = covidService;
    }

    @GetMapping(PATH_GET_DAILY_REPORT)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    CGReport getDailyReport() {
        return covidService.getDailyReport();
    }

    @GetMapping(PATH_GET_PERIODIC_REPORT)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<CGReport> getPeriodicReport(@PathVariable String from, @PathVariable String to) {
        return covidService.getPeriodicReport(from, to);
    }

    @GetMapping(PATH_GET_ALL_PROVINCE_REPORT)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<CPReport> getAllProvinceReports() {
        return covidService.getAllProvinceReports();
    }

    @GetMapping(PATH_GET_SINGLE_PROVINCE_REPORT)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    CPReport getReportByProvince(@PathVariable String name) {
        return covidService.getReportByProvince(name);
    }

    @GetMapping(PATH_GET_ALL_DISTRICT_REPORT)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<CDReport> getAllDistrictReports() {
        return covidService.getAllDistrictReports();
    }

    @GetMapping(PATH_GET_SINGLE_DISTRICT_REPORT)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    CDReport getReportByDistrict(@PathVariable String name) {
        return covidService.getReportByDistrict(name);
    }
}
