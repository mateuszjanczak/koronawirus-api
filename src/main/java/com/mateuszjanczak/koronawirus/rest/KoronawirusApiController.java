package com.mateuszjanczak.koronawirus.rest;

import com.mateuszjanczak.koronawirus.domain.model.Raport;
import com.mateuszjanczak.koronawirus.service.KoronawirusService;
import com.mateuszjanczak.koronawirus.webscraper.KoronawirusWebscraper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class KoronawirusApiController {

    @Autowired
    KoronawirusService koronawirusService;

    @CrossOrigin
    @GetMapping
    public ResponseEntity<ArrayList<Raport>> getRaports(){
        return new ResponseEntity<>(koronawirusService.getAll(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/id/{id}")
    public ResponseEntity<Raport> getRaportById(@PathVariable int id){
        return new ResponseEntity<>(koronawirusService.getById(id), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/wojewodztwo/{wojewodztwo}")
    public ResponseEntity<Raport> getRaportByWojewodztwo(@PathVariable String wojewodztwo){
        return new ResponseEntity<>(koronawirusService.getByWojewodztwo(wojewodztwo), HttpStatus.OK);
    }

}
