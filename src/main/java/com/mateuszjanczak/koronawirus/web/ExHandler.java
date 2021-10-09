package com.mateuszjanczak.koronawirus.web;

import com.mateuszjanczak.koronawirus.dto.ErrorResponse;
import com.mateuszjanczak.koronawirus.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExHandler {

    @ExceptionHandler(BadDateFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody
    ErrorResponse handleBadFormatException() {
        String errorMessage = "Bad date format. Use ['yyyy-MM-dd', 'yyyy-MM-dd HH:mm']";
        return new ErrorResponse(HttpStatus.BAD_REQUEST, errorMessage);
    }

    @ExceptionHandler(BadDistrictNameException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody
    ErrorResponse handleBadDistrictNameException() {
        String errorMessage = "Bad district name.";
        return new ErrorResponse(HttpStatus.BAD_REQUEST, errorMessage);
    }

    @ExceptionHandler(BadProvinceNameException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody
    ErrorResponse handleBadProvinceNameException() {
        String errorMessage = "Bad province name.";
        return new ErrorResponse(HttpStatus.BAD_REQUEST, errorMessage);
    }

    @ExceptionHandler(BadPointNameException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody
    ErrorResponse handleBadPointNameException() {
        String errorMessage = "Bad point name.";
        return new ErrorResponse(HttpStatus.BAD_REQUEST, errorMessage);
    }

    @ExceptionHandler(ApiErrorException.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public @ResponseBody
    ErrorResponse handleApiErrorException() {
        String errorMessage = "The original server is not responding.";
        return new ErrorResponse(HttpStatus.SERVICE_UNAVAILABLE, errorMessage);
    }

    @ExceptionHandler({IncompleteDataException.class, NullPointerException.class})
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public @ResponseBody
    ErrorResponse handleIncompleteDataException() {
        String errorMessage = "No complete data from today.";
        return new ErrorResponse(HttpStatus.SERVICE_UNAVAILABLE, errorMessage);
    }
}
