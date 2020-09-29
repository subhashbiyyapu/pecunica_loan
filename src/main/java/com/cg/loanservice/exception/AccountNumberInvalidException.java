package com.cg.loanservice.exception;

public class AccountNumberInvalidException extends RuntimeException {

	public AccountNumberInvalidException() {
		super();
		
	}

	public AccountNumberInvalidException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public AccountNumberInvalidException(String message) {
		super(message);
		
	}

	public AccountNumberInvalidException(Throwable cause) {
		super(cause);
		
	}

	
}
