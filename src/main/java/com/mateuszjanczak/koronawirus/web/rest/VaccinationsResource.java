package com.mateuszjanczak.koronawirus.web.rest;

import com.mateuszjanczak.koronawirus.model.vaccinations.district.VDReport;
import com.mateuszjanczak.koronawirus.model.vaccinations.global.VGReport;
import com.mateuszjanczak.koronawirus.model.vaccinations.points.VPPReport;
import com.mateuszjanczak.koronawirus.model.vaccinations.province.VPReport;
import com.mateuszjanczak.koronawirus.service.interfaces.IVaccinationsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mateuszjanczak.koronawirus.web.rest.AdminResource.*;

@RestController
@CrossOrigin
@RequestMapping(VACCINATIONS_API)
public class VaccinationsResource {

    final private IVaccinationsService vaccinationsService;

    public VaccinationsResource(IVaccinationsService vaccinationsService) {
        this.vaccinationsService = vaccinationsService;
    }

    @GetMapping(PATH_GET_DAILY_REPORT)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    VGReport getDailyReport() {
        return vaccinationsService.getDailyReport();
    }

    @GetMapping(PATH_GET_PERIODIC_REPORT)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<VGReport> getPeriodicReport(@PathVariable String from, @PathVariable String to) {
        return vaccinationsService.getPeriodicReport(from, to);
    }

    @GetMapping(PATH_GET_ALL_PROVINCE_REPORT)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<VPReport> getAllProvinceReports() {
        return vaccinationsService.getAllProvinceReports();
    }

    @GetMapping(PATH_GET_SINGLE_PROVINCE_REPORT)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    VPReport getReportByProvince(@PathVariable String name) {
        return vaccinationsService.getReportByProvince(name);
    }

    @GetMapping(PATH_GET_ALL_DISTRICT_REPORT)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<VDReport> getAllDistrictReports() {
        return vaccinationsService.getAllDistrictReports();
    }

    @GetMapping(PATH_GET_SINGLE_DISTRICT_REPORT)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    VDReport getReportByDistrict(@PathVariable String name) {
        return vaccinationsService.getReportByDistrict(name);
    }

    @GetMapping(PATH_GET_ALL_POINT_REPORT)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<VPPReport> getAllPointsReports() {
        return vaccinationsService.getAllPointsReports();
    }

    @GetMapping(PATH_GET_SINGLE_POINT_REPORT)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    VPPReport getReportByName(@PathVariable String name) {
        return vaccinationsService.getReportByPoint(name);
    }

}
