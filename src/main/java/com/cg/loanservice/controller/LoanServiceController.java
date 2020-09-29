package com.cg.loanservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.cg.loanservice.entity.LoanRequestEntity;
import com.cg.loanservice.service.LoanService;

@RestController
public class LoanServiceController {
	
	@Autowired
	LoanService service;
	
	 Logger logger = LoggerFactory.getLogger(LoanServiceController.class);
	
	@GetMapping(value="/account")
	@ResponseBody public  Boolean isAccountNoValid( @RequestParam Long accountNo)
	{
		logger.info("In controller validating "+accountNo);
		return service.isAccountNoValid(accountNo);
		
	}
	
	@PostMapping(value="/loanrequest")
	public @ResponseBody LoanRequestEntity addLoanRequest(@Valid @RequestBody LoanRequestEntity loanRequestObj) {
		logger.info("In controller adding loanrequest  ");
		return service.addLoanRequest(loanRequestObj);
		
	}
	
	@PutMapping(value="/loanapproval")
	public @ResponseBody  Boolean acceptLoanRequest(@RequestParam Long loanRequestId,@RequestParam Long employeeId) 
	
		{
		logger.info("In controller accepting loan request  "+loanRequestId+" "+employeeId);
			return service.acceptLoanRequest(loanRequestId, employeeId);
		}
	
	
	@PutMapping(value="/loanrejected")
	   public Boolean rejectLoanRequest(@RequestParam  Long loanRequestId) {
		logger.info("In controller rejecting  loan request  "+loanRequestId);
		return service.rejectLoanRequest(loanRequestId);
	}
	
	@GetMapping(value="/loanrequests")
	public @ResponseBody List<LoanRequestEntity> fetchAllLoanRequests() {
		logger.info("In controller fetching all pending requests  ");
		return service.fetchAllLoanRequests();
		
	}
}
