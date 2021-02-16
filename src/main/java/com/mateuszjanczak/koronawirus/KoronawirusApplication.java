package com.mateuszjanczak.koronawirus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KoronawirusApplication {

    public static void main(String[] args) {
        SpringApplication.run(KoronawirusApplication.class, args);
    }

}
