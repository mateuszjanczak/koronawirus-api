package com.mateuszjanczak.koronawirus.web.rest;

import com.mateuszjanczak.koronawirus.model.covid.CovidReport;
import com.mateuszjanczak.koronawirus.model.vaccinations.VaccinationsReport;
import com.mateuszjanczak.koronawirus.service.IVaccinationsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/vaccinations")
public class VaccinationsResource {

    final private IVaccinationsService vaccinationsService;

    public VaccinationsResource(IVaccinationsService vaccinationsService) {
        this.vaccinationsService = vaccinationsService;
    }

    @GetMapping("/daily")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody VaccinationsReport getDailyReport() {
        return vaccinationsService.getDailyReport();
    }

    @GetMapping("/from/{from}/to/{to}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<VaccinationsReport> getPeriodicReport(@PathVariable String from, @PathVariable String to) {
        return vaccinationsService.getPeriodicReport(from, to);
    }
}
