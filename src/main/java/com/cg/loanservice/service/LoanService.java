package com.cg.loanservice.service;

import java.util.List;

import com.cg.loanservice.entity.LoanRequestEntity;

public interface LoanService {
	Boolean isAccountNoValid(Long AccountNo);
	LoanRequestEntity addLoanRequest(LoanRequestEntity loanRequestObj);
	 Boolean acceptLoanRequest(Long LoanRequestId,Long employeeId);
	 Boolean rejectLoanRequest(Long LoanRequestId);
	 List<LoanRequestEntity> fetchAllLoanRequests();
	 

}
