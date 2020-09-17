package com.mateuszjanczak.koronawirus.web.rest;

import com.mateuszjanczak.koronawirus.model.Report;
import com.mateuszjanczak.koronawirus.service.KoronawirusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class KoronawirusApiController {

    private final KoronawirusService koronawirusService;

    public KoronawirusApiController(KoronawirusService koronawirusService) {
        this.koronawirusService = koronawirusService;
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<Report>> getReports(){
        return new ResponseEntity<>(koronawirusService.getAll(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/id/{id}")
    public ResponseEntity<Report> getReportById(@PathVariable int id){
        return new ResponseEntity<>(koronawirusService.getById(id), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/wojewodztwo/{wojewodztwo}")
    public ResponseEntity<Report> getReportByWojewodztwo(@PathVariable String wojewodztwo){
        return new ResponseEntity<>(koronawirusService.getByWojewodztwo(wojewodztwo), HttpStatus.OK);
    }
}
