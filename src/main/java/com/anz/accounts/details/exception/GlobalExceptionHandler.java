package com.anz.accounts.details.exception;

import com.anz.accounts.details.api.ApiError;
import com.anz.accounts.details.api.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AccountsDetailException.class)
    public ResponseEntity<ApiError> handleAccountsDetailException(AccountsDetailException exception, HttpServletRequest request) {
        log.debug("Microservice Exception Message: "+ exception.getMessage());
        ApiError apiError = buildErrorResponse(exception, exception.getStatus());
        return new ResponseEntity<>(apiError, exception.getStatus().getHttpStatus());
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleException(Exception exception, HttpServletRequest request) {
        log.debug("Exception Message : "+ exception.getMessage());
        ApiError apiError = buildErrorResponse(exception, Status.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ApiError buildErrorResponse(Exception exception, Status status) {
        String detailsMessage = exception.getMessage();

        return ApiError.builder()
                .errorId(status.getErrorId())
                .message(status.getErrorMessage())
                .details(detailsMessage)
                .build();

    }

}
