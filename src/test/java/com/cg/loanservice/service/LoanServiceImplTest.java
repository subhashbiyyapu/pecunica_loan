package com.cg.loanservice.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.cg.loanservice.dao.LoanServiceDao;
import com.cg.loanservice.entity.LoanRequestEntity;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class LoanServiceImplTest {

	@InjectMocks
	@Autowired
	LoanServiceImpl service;
	@Autowired
	LoanServiceDao dao;
	
	@Mock
    private RestTemplate restTemplate;
	
	
	
@Test
void rejectLoanRequestTest()
{
	LoanRequestEntity obj=new LoanRequestEntity();
	obj.setLoanStatus("pending");
	service.addLoanRequest(obj);
	service.rejectLoanRequest((long) 3);
	LoanRequestEntity returnedObj= dao.findById((long)3).get();
	assertEquals("rejected",returnedObj.getLoanStatus());
	
}

@Test
void fetchLoanRequests()
{
	List<LoanRequestEntity> loanList=service.fetchAllLoanRequests();
	long temp[]=new long[2];
	long test[]= {2,1};
	int i=0;
	
	for(LoanRequestEntity entity :loanList)
	{
	temp[i]=entity.getLoanRequestId();
	i++;
	}
	assertArrayEquals(test, temp);
}

}

