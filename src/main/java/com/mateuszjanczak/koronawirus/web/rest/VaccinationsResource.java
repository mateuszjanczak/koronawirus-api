package com.mateuszjanczak.koronawirus.web.rest;

import com.mateuszjanczak.koronawirus.model.vaccinations.district.VDReport;
import com.mateuszjanczak.koronawirus.model.vaccinations.global.VGReport;
import com.mateuszjanczak.koronawirus.model.vaccinations.points.VPPReport;
import com.mateuszjanczak.koronawirus.model.vaccinations.province.VPReport;
import com.mateuszjanczak.koronawirus.service.interfaces.IVaccinationsService;
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
    public @ResponseBody
    VGReport getDailyReport() {
        return vaccinationsService.getDailyReport();
    }

    @GetMapping("/from/{from}/to/{to}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<VGReport> getPeriodicReport(@PathVariable String from, @PathVariable String to) {
        return vaccinationsService.getPeriodicReport(from, to);
    }

    @GetMapping("/province")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<VPReport> getAllProvinceReports() {
        return vaccinationsService.getAllProvinceReports();
    }

    @GetMapping("/province/{name}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    VPReport getReportByProvince(@PathVariable String name) {
        return vaccinationsService.getReportByProvince(name);
    }

    @GetMapping("/district")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<VDReport> getAllDistrictReports() {
        return vaccinationsService.getAllDistrictReports();
    }

    @GetMapping("/district/{name}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    VDReport getReportByDistrict(@PathVariable String name) {
        return vaccinationsService.getReportByDistrict(name);
    }

    @GetMapping("/point")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<VPPReport> getAllPointsReports() {
        return vaccinationsService.getAllPointsReports();
    }

    @GetMapping("/point/{name}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    VPPReport getReportByName(@PathVariable String name) {
        return vaccinationsService.getReportByPoint(name);
    }

}
