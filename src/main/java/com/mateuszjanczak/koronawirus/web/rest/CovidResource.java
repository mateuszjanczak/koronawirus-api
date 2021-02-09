package com.mateuszjanczak.koronawirus.web.rest;

import com.mateuszjanczak.koronawirus.model.covid.district.CDReport;
import com.mateuszjanczak.koronawirus.model.covid.global.CGReport;
import com.mateuszjanczak.koronawirus.model.covid.province.CPReport;
import com.mateuszjanczak.koronawirus.model.vaccinations.district.VDReport;
import com.mateuszjanczak.koronawirus.service.interfaces.ICovidService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/covid19")
public class CovidResource {

    private final ICovidService covidService;

    public CovidResource(ICovidService covidService) {
        this.covidService = covidService;
    }

    @GetMapping("/daily")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    CGReport getDailyReport() {
        return covidService.getDailyReport();
    }

    @GetMapping("/from/{from}/to/{to}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<CGReport> getPeriodicReport(@PathVariable String from, @PathVariable String to) {
        return covidService.getPeriodicReport(from, to);
    }

    @GetMapping("/province")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<CPReport> getAllProvinceReports() {
        return covidService.getAllProvinceReports();
    }

    @GetMapping("/province/{name}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    CPReport getReportByProvince(@PathVariable String name) {
        return covidService.getReportByProvince(name);
    }

    @GetMapping("/district")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<CDReport> getAllDistrictReports() {
        return covidService.getAllDistrictReports();
    }

    @GetMapping("/district/{name}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    CDReport getReportByDistrict(@PathVariable String name) {
        return covidService.getReportByDistrict(name);
    }
}
