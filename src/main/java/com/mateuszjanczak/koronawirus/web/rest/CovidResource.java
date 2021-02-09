package com.mateuszjanczak.koronawirus.web.rest;

import com.mateuszjanczak.koronawirus.model.covid.CovidReport;
import com.mateuszjanczak.koronawirus.model.voivodeship.VoivodeshipReport;
import com.mateuszjanczak.koronawirus.service.ICovidService;
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
    CovidReport getDailyReport() {
        return covidService.getDailyReport();
    }

    @GetMapping("/from/{from}/to/{to}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<CovidReport> getPeriodicReport(@PathVariable String from, @PathVariable String to) {
        return covidService.getPeriodicReport(from, to);
    }

    @GetMapping("/voivodeship")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<VoivodeshipReport> getAllVoivodeshipReports() {
        return covidService.getAllVoivodeshipReports();
    }

    @GetMapping("/voivodeship/{name}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody VoivodeshipReport getReportByVoivodeship(@PathVariable String name) {
        return covidService.getReportByVoivodeship(name);
    }
}
