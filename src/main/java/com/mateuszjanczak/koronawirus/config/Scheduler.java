package com.mateuszjanczak.koronawirus.config;

import com.mateuszjanczak.koronawirus.repository.ICache;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

    private final ICache covidRepository;

    public Scheduler(ICache covidRepository) {
        this.covidRepository = covidRepository;
    }

    @Scheduled(fixedRate = 900000)
    public void executeTask() {
        covidRepository.fetchAll();
        System.out.println("UPDATE");
    }
}
