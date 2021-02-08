package com.mateuszjanczak.koronawirus.web;

import com.mateuszjanczak.koronawirus.dto.ErrorResponse;
import com.mateuszjanczak.koronawirus.exception.ApiErrorException;
import com.mateuszjanczak.koronawirus.exception.BadFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExHandler {

    @ExceptionHandler(BadFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse handleBadFormatException(){
        String errorMessage = "Bad date format. Use ['yyyy-MM-dd','yyyy-MM-dd HH:mm']";
        return new ErrorResponse(HttpStatus.BAD_REQUEST, errorMessage);
    }

    @ExceptionHandler(ApiErrorException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse handleApiErrorException(){
        String errorMessage = "The original server is not responding.";
        return new ErrorResponse(HttpStatus.SERVICE_UNAVAILABLE, errorMessage);
    }
}
