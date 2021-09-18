package com.mateuszjanczak.koronawirus.web.rest;

import com.mateuszjanczak.koronawirus.repository.ICache;
import com.mateuszjanczak.koronawirus.service.MixFacade;
import com.mateuszjanczak.koronawirus.service.interfaces.ICovidService;
import com.mateuszjanczak.koronawirus.service.interfaces.ITestsService;
import com.mateuszjanczak.koronawirus.service.interfaces.IVaccinationsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
public class AdminResource {
    public static final String COVID_API = "/api/covid19";
    public static final String VACCINATIONS_API = "/api/vaccinations";
    public static final String TESTS_API = "/api/tests";
    public static final String COVID_VACCINATIONS_TESTS_API = "/api/covid-vaccinations-tests";
    public static final String PATH_GET_DAILY_REPORT = "/daily";
    public static final String PATH_GET_PERIODIC_REPORT = "/from/{from}/to/{to}";
    public static final String PATH_GET_ALL_PROVINCE_REPORT = "/province";
    public static final String PATH_GET_SINGLE_PROVINCE_REPORT = "/province/{name}";
    public static final String PATH_GET_ALL_DISTRICT_REPORT = "/district";
    public static final String PATH_GET_SINGLE_DISTRICT_REPORT = "/district/{name}";
    public static final String PATH_GET_ALL_POINT_REPORT = "/point";
    public static final String PATH_GET_SINGLE_POINT_REPORT = "/point/{name}";
    private final ICovidService covidService;
    private final IVaccinationsService vaccinationsService;
    private final ITestsService testsService;
    private final MixFacade mixFacade;
    private final ICache covidRepository;
    private final ICache vaccinationsRepository;
    private final ICache testsRepository;

    public AdminResource(ICovidService covidService, IVaccinationsService vaccinationsService, ITestsService testsService, MixFacade mixFacade, ICache covidRepository, ICache vaccinationsRepository, ICache testsRepository) {
        this.covidService = covidService;
        this.vaccinationsService = vaccinationsService;
        this.testsService = testsService;
        this.mixFacade = mixFacade;
        this.covidRepository = covidRepository;
        this.vaccinationsRepository = vaccinationsRepository;
        this.testsRepository = testsRepository;
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    HashMap<String, HashMap<String, String>> index(HttpServletRequest request) {
        HashMap<String, HashMap<String, String>> res = new HashMap<>();

        HashMap<String, String> all = new HashMap<>();
        all.put("getDailyReport", getCurrentUrl(request, COVID_VACCINATIONS_TESTS_API) + PATH_GET_DAILY_REPORT);
        res.put("all", all);

        HashMap<String, String> covid = new HashMap<>();
        covid.put("getDailyReport", getCurrentUrl(request, COVID_API) + PATH_GET_DAILY_REPORT);
        covid.put("getAllDistrictReports", getCurrentUrl(request, COVID_API) + PATH_GET_ALL_DISTRICT_REPORT);
        covid.put("getAllProvinceReports", getCurrentUrl(request, COVID_API) + PATH_GET_ALL_PROVINCE_REPORT);
        res.put("covid", covid);

        HashMap<String, String> vaccinations = new HashMap<>();
        vaccinations.put("getDailyReport", getCurrentUrl(request, VACCINATIONS_API) + PATH_GET_DAILY_REPORT);
        vaccinations.put("getAllDistrictReports", getCurrentUrl(request, VACCINATIONS_API) + PATH_GET_ALL_DISTRICT_REPORT);
        vaccinations.put("getAllProvinceReports", getCurrentUrl(request, VACCINATIONS_API) + PATH_GET_ALL_PROVINCE_REPORT);
        vaccinations.put("getAllPointsReports", getCurrentUrl(request, VACCINATIONS_API) + PATH_GET_ALL_POINT_REPORT);
        res.put("vaccinations", vaccinations);

        HashMap<String, String> tests = new HashMap<>();
        vaccinations.put("getDailyReport", getCurrentUrl(request, TESTS_API) + PATH_GET_DAILY_REPORT);
        res.put("tests", tests);

        return res;
    }

    private String getCurrentUrl(HttpServletRequest request, String api) {
        String requestUrl = request.getRequestURL().toString();
        return requestUrl.substring(0, requestUrl.length() - 1) + api;
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
        testsService.getDailyReport();
        mixFacade.getDailyReport();
    }

    @GetMapping("/forceUpdate")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    void forceUpdate() {
        covidRepository.fetchAll();
        vaccinationsRepository.fetchAll();
        testsRepository.fetchAll();
    }
}
