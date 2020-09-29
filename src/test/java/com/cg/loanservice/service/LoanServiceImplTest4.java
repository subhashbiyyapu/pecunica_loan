package com.cg.loanservice.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.loanservice.dao.LoanServiceDao;
import com.cg.loanservice.entity.LoanRequestEntity;
@SpringBootTest
class LoanServiceImplTest4 {

	@Autowired
	LoanServiceImpl service;
	@Autowired
	LoanServiceDao dao;
	
	
	@Test
	void rejectLoanRequestTest()
	{
		LoanRequestEntity request1=new LoanRequestEntity(121L, 5555555555L, 100000.0, "homeloan", 12.5, 36, 670, "pending", 123456L);
		
		service.addLoanRequest(request1);
		service.rejectLoanRequest((long) 3);
		LoanRequestEntity returnedObj= dao.findById((long)3).get();
		assertEquals("rejected",returnedObj.getLoanStatus());
		dao.deleteById(3L);
	}

}
