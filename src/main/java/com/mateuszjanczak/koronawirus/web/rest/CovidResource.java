package com.mateuszjanczak.koronawirus.web.rest;

import com.mateuszjanczak.koronawirus.model.Report;
import com.mateuszjanczak.koronawirus.service.ICovidService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public @ResponseBody Report getDailyReport() {
        return covidService.getDailyReport();
    }
}
