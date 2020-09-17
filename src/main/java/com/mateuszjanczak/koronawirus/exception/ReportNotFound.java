package com.mateuszjanczak.koronawirus.exception;

public class ReportNotFound extends RuntimeException {

    public ReportNotFound(int message) {
        super("Report " + message + " not found");
    }

    public ReportNotFound(String message) {
        super("Report " + message + " not found");
    }

}