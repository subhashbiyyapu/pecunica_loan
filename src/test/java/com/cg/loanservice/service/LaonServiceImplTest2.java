package com.cg.loanservice.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.loanservice.dao.LoanServiceDao;
import com.cg.loanservice.entity.LoanRequestEntity;
@SpringBootTest
class LaonServiceImplTest2 {

	@Autowired
	LoanServiceImpl service;
	@Autowired
	LoanServiceDao dao;
	@Test
	void addLoanRequest()
	{
		LoanRequestEntity obj=new LoanRequestEntity();
		LoanRequestEntity returnedObj=service.addLoanRequest(obj);
		assertEquals(3, obj.getLoanRequestId());
		dao.deleteById((long) 3);
	}

}
