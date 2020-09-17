package com.mateuszjanczak.koronawirus.web;

import com.mateuszjanczak.koronawirus.dto.ErrorResponse;
import com.mateuszjanczak.koronawirus.exception.ReportNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(ReportNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleReportNotFound(ReportNotFound ex) {
        String errorMessage = ex.getMessage();
        return new ErrorResponse(HttpStatus.NOT_FOUND, errorMessage);
    }
}
