package com.mateuszjanczak.koronawirus.config;

import com.mateuszjanczak.koronawirus.repository.ICache;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Scheduler {

    private final ICache covidRepository;
    private final ICache vaccinationsRepository;
    private final ICache testsRepository;

    public Scheduler(ICache covidRepository, ICache vaccinationsRepository, ICache testsRepository) {
        this.covidRepository = covidRepository;
        this.vaccinationsRepository = vaccinationsRepository;
        this.testsRepository = testsRepository;
    }

    @Scheduled(fixedRate = 900000)
    public void executeTask() {
        covidRepository.fetchAll();
        vaccinationsRepository.fetchAll();
        testsRepository.fetchAll();
        System.out.println("UPDATE " + new Date().toString());
    }
}
