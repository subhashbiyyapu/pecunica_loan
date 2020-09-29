package com.cg.loanservice.service;

import java.util.List;

import com.cg.loanservice.entity.LoanRequestEntity;

public interface LoanService {
	Boolean isAccountNoValid(Long accountNo);
	LoanRequestEntity addLoanRequest(LoanRequestEntity loanRequestObj);
	 Boolean acceptLoanRequest(Long loanRequestId,Long employeeId);
	 Boolean rejectLoanRequest(Long loanRequestId);
	 List<LoanRequestEntity> fetchAllLoanRequests();
	 

}
