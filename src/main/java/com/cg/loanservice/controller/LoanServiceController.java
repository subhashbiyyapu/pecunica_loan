package com.cg.loanservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
	
	@GetMapping(value="/account")
	@ResponseBody Boolean isAccountNoValid( @RequestParam Long AccountNo)
	{
		return service.isAccountNoValid(AccountNo);
		
	}
	
	@PostMapping(value="/loanrequest")
	public @ResponseBody LoanRequestEntity addLoanRequest(@Valid @RequestBody LoanRequestEntity loanRequestObj) {
		return service.addLoanRequest(loanRequestObj);
		
	}
	
	@PutMapping(value="/loanapproval")
	public @ResponseBody  Boolean acceptLoanRequest(@RequestParam Long LoanRequestId,@RequestParam Long employeeId) 
	
		{
			return service.acceptLoanRequest(LoanRequestId, employeeId);
		}
	
	
	@PutMapping(value="/loanrejected")
	   public Boolean rejectLoanRequest(@RequestParam  Long LoanRequestId) {
		return service.rejectLoanRequest(LoanRequestId);
	}
	
	@GetMapping(value="/loanrequests")
	public @ResponseBody List<LoanRequestEntity> fetchAllLoanRequests() {
		return service.fetchAllLoanRequests();
		
	}
}
