package com.cg.loanservice.service;

import java.util.List;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import  com.cg.loanservice.dao.LoanServiceDao;
import com.cg.loanservice.entity.LoanRequestEntity;
import com.cg.loanservice.exception.AccountNumberInvalidException;


@Service
public class LoanServiceImpl  implements LoanService{
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	LoanServiceDao loanServiceDao;

	@Override
	public Boolean isAccountNoValid(Long AccountNo) {
		//URL has to be written 
	Boolean validity= restTemplate.getForObject(" ", Boolean.class);
	if(validity==false)
	{
		throw new AccountNumberInvalidException("account number is invalid");
	}
	else
		return true;
	}

	@Override
	@Transactional
	public LoanRequestEntity addLoanRequest(LoanRequestEntity loanRequestObj) {
		
		return loanServiceDao.save(loanRequestObj);
	}

	@Override
	public Boolean acceptLoanRequest(Long LoanRequestId, Long employeeId) {
		LoanRequestEntity loanRequestObj=loanServiceDao.findById(LoanRequestId).get();
	    loanRequestObj.setEmployeeId(employeeId);
	    loanRequestObj.setLoanStatus("accepted");
	    loanServiceDao.saveAndFlush(loanRequestObj);
		
	    //URL has to be written 
		return restTemplate.postForObject("http://localhost:9092/loan", loanRequestObj,Boolean.class);
		
	}

	@Override
	@Transactional
	public Boolean rejectLoanRequest(Long LoanRequestId) {
		LoanRequestEntity loanRequestObj=loanServiceDao.findById(LoanRequestId).get();
		 loanRequestObj.setLoanStatus("rejected");
		 return true;
	}

	@Override
	public List<LoanRequestEntity> fetchAllLoanRequests() {
		//Sort sort = Sort.by("loanRequestId").ascending();
		return loanServiceDao.findByLoanStatus("pending",Sort.by(Direction.DESC,"loanRequestId"));
	
	}

}
