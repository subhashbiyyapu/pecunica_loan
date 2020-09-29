package com.cg.loanservice.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AccountNumberValidator implements  ConstraintValidator <AccountNumber, Long>{

	
	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
		Long max= 9999999999L;
		return  (value > 1000000000L) && (value <( max));
	}

}
