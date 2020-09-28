package com.cg.loanservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.cg.loanservice.exception.AccountNumberInvalidException;

@ControllerAdvice
public class LoanRequestServiceControllerAdvice {

	@ExceptionHandler(AccountNumberInvalidException.class)
    public final ResponseEntity<String> exceptionHandlerForRoomNotFound
                        ( AccountNumberInvalidException e) 
    {

        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
