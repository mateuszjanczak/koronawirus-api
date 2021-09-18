package com.mateuszjanczak.koronawirus.web.rest;

import com.mateuszjanczak.koronawirus.model.tests.TGReport;
import com.mateuszjanczak.koronawirus.service.interfaces.ITestsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mateuszjanczak.koronawirus.web.rest.AdminResource.*;

@RestController
@CrossOrigin
@RequestMapping(TESTS_API)
public class TestsResource {
    private final ITestsService testsService;

    public TestsResource(ITestsService testsService) {
        this.testsService = testsService;
    }

    @GetMapping(PATH_GET_DAILY_REPORT)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    TGReport getDailyReport() {
        return testsService.getDailyReport();
    }

    @GetMapping(PATH_GET_PERIODIC_REPORT)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<TGReport> getPeriodicReport(@PathVariable String from, @PathVariable String to) {
        return testsService.getPeriodicReport(from, to);
    }
}
