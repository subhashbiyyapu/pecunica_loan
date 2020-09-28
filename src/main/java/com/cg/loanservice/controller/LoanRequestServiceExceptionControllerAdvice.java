package com.cg.loanservice.controller;

import org.springframework.http.HttpHeaders;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cg.loanservice.dto.ExceptionResponse;
import com.cg.loanservice.exception.AccountNumberInvalidException;

@ControllerAdvice
@RestController
public class LoanRequestServiceExceptionControllerAdvice extends ResponseEntityExceptionHandler {
	
	 @ExceptionHandler(Exception.class)
	  public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
	    ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
	        request.getDescription(false));
	    return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	@ExceptionHandler(AccountNumberInvalidException.class)
    public final ResponseEntity<String> exceptionHandlerForRoomNotFound
                        ( AccountNumberInvalidException e) 
    {

        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
	
	
	@Override
	 protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,HttpHeaders headers, HttpStatus status, WebRequest request) {
	      ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Validation Failed",
	        ex.getBindingResult().toString());
	    return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
	  } 
}
