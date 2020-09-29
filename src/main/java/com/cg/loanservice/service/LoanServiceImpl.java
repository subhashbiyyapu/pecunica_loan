package com.cg.loanservice.service;

import java.util.List;


import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	Logger logger = LoggerFactory.getLogger(LoanServiceImpl.class);

	@Override
	public Boolean isAccountNoValid(Long accountNo) {
		//URL has to be written 
	Boolean validity= restTemplate.getForObject(" ", Boolean.class);
	if(!validity)
	{
		logger.info("In service account number is invalid");
		throw new AccountNumberInvalidException("account number is invalid");
	}
	else
	{
		logger.info("In service account number is valid");

		return true;
	}
	}

	@Override
	@Transactional
	public LoanRequestEntity addLoanRequest(LoanRequestEntity loanRequestObj) {
		
		logger.info("In service adding loan request");
		loanRequestObj.setLoanStatus("pending");
		return loanServiceDao.save(loanRequestObj);
	}

	@Override
	public Boolean acceptLoanRequest(Long loanRequestId, Long employeeId) {
		LoanRequestEntity loanRequestObj=loanServiceDao.findById(loanRequestId).get();
	    loanRequestObj.setEmployeeId(employeeId);
	    loanRequestObj.setLoanStatus("accepted");
	    loanServiceDao.saveAndFlush(loanRequestObj);
		logger.info("In service accepting loan request"+loanRequestId);

	    //URL has to be written 
		return restTemplate.postForObject("http://localhost:9092/loan", loanRequestObj,Boolean.class);
		
	}

	@Override
	@Transactional
	public Boolean rejectLoanRequest(Long loanRequestId) {
		LoanRequestEntity loanRequestObj=loanServiceDao.findById(loanRequestId).get();
		 loanRequestObj.setLoanStatus("rejected");
		 logger.info("In service rejecting loan request"+loanRequestId);
		 return true;
	}

	@Override
	public List<LoanRequestEntity> fetchAllLoanRequests() {
		
		logger.info("In service fetching pending  loan requests");
		return loanServiceDao.findByLoanStatus("pending",Sort.by(Direction.DESC,"loanRequestId"));
	
	}

}
