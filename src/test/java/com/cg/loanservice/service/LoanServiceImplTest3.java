package com.cg.loanservice.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import com.cg.loanservice.dao.LoanServiceDao;
import com.cg.loanservice.entity.LoanRequestEntity;
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class LoanServiceImplTest3 {

	@InjectMocks
	@Autowired
	LoanServiceImpl service;
	@Autowired
	LoanServiceDao dao;
	
	@Mock
    private RestTemplate restTemplate;
	
	//MockRestServiceServer  mockServer =MockRestServiceServer.createServer(restTemplate);
	@Test
	void acceptLoanRequest()
	{
		LoanRequestEntity obj=new LoanRequestEntity();
		 Mockito
         .when( restTemplate.postForObject("http://localhost:9092/loan",obj,Boolean.class))
         .thenReturn(true);
		service.addLoanRequest(obj);
		service.acceptLoanRequest((long)3, (long)12345);
		assertEquals("accepted",dao.findById((long)(3)).get().getLoanStatus() );
	
	}
	

}
