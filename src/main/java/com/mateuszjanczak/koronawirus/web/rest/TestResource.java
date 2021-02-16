package com.mateuszjanczak.koronawirus.web.rest;

import com.mateuszjanczak.koronawirus.repository.ICache;
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
    private final ICache covidRepository;
    private final ICache vaccinationsRepository;

    public static final String COVID_API = "/api/covid19";
    public static final String VACCINATIONS_API = "/api/vaccinations";
    public static final String PATH_GET_DAILY_REPORT = "/daily";
    public static final String PATH_GET_PERIODIC_REPORT = "/from/{from}/to/{to}";
    public static final String PATH_GET_ALL_PROVINCE_REPORT = "/province";
    public static final String PATH_GET_SINGLE_PROVINCE_REPORT = "/province/{name}";
    public static final String PATH_GET_ALL_DISTRICT_REPORT = "/district";
    public static final String PATH_GET_SINGLE_DISTRICT_REPORT = "/district/{name}";
    public static final String PATH_GET_ALL_POINT_REPORT = "/point";
    public static final String PATH_GET_SINGLE_POINT_REPORT = "/point/{name}";

    public TestResource(ICovidService covidService, IVaccinationsService vaccinationsService, ICache covidRepository, ICache vaccinationsRepository) {
        this.covidService = covidService;
        this.vaccinationsService = vaccinationsService;
        this.covidRepository = covidRepository;
        this.vaccinationsRepository = vaccinationsRepository;
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    void index() {
        covidService.getDailyReport();
        covidService.getAllDistrictReports();
        covidService.getAllProvinceReports();
        vaccinationsService.getDailyReport();
        vaccinationsService.getAllDistrictReports();
        vaccinationsService.getAllProvinceReports();
        vaccinationsService.getAllPointsReports();
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

    @GetMapping("/forceUpdate")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    void forceUpdate() {
        covidRepository.fetchAll();
        vaccinationsRepository.fetchAll();
    }
}
