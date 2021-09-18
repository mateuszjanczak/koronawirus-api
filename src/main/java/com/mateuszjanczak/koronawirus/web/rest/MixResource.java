package com.mateuszjanczak.koronawirus.web.rest;

import com.mateuszjanczak.koronawirus.model.mix.global.MGReport;
import com.mateuszjanczak.koronawirus.service.MixFacade;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mateuszjanczak.koronawirus.web.rest.AdminResource.*;

@RestController
@CrossOrigin
@RequestMapping(COVID_VACCINATIONS_TESTS_API)
public class MixResource {
    private final MixFacade mixFacade;

    public MixResource(MixFacade mixFacade) {
        this.mixFacade = mixFacade;
    }

    @GetMapping(PATH_GET_DAILY_REPORT)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    MGReport getDailyReport() {
        return mixFacade.getDailyReport();
    }

    @GetMapping(PATH_GET_PERIODIC_REPORT)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<MGReport> getPeriodicReport(@PathVariable String from, @PathVariable String to) {
        return mixFacade.getPeriodicReport(from, to);
    }
}
