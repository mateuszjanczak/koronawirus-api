package com.mateuszjanczak.koronawirus.web.rest;

import com.mateuszjanczak.koronawirus.service.interfaces.ICovidService;
import com.mateuszjanczak.koronawirus.service.interfaces.IVaccinationsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestResource {
    private final ICovidService covidService;
    private final IVaccinationsService vaccinationsService;

    public TestResource(ICovidService covidService, IVaccinationsService vaccinationsService) {
        this.covidService = covidService;
        this.vaccinationsService = vaccinationsService;
    }

    @GetMapping("/test")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    void test() {
        covidService.getDailyReport();
        covidService.getAllDistrictReports();
        covidService.getAllProvinceReports();
        vaccinationsService.getDailyReport();
        vaccinationsService.getAllDistrictReports();
        vaccinationsService.getAllProvinceReports();
        vaccinationsService.getAllPointsReports();
    }
}
