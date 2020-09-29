package com.cg.loanservice.service;

import static org.junit.jupiter.api.Assertions.*;


import java.util.List;

import org.junit.After;
import org.junit.Before;
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


@SpringBootTest
class LoanServiceImplTest {


	@Autowired
	LoanServiceImpl service;
	@Autowired
	LoanServiceDao dao;
	

	



@Test
void fetchLoanRequests()
{
	LoanRequestEntity request1=new LoanRequestEntity(121L, 5555555555L, 100000.0, "homeloan", 12.5, 36, 670, "pending", 123456L);
	LoanRequestEntity request2=new LoanRequestEntity(122L, 5555555556L, 100000.0, "homeloan", 12.5, 36, 670, "pending", 123456L);
	service.addLoanRequest(request1);
	service.addLoanRequest(request2);

	service.rejectLoanRequest(3L);
	List<LoanRequestEntity> loanList=service.fetchAllLoanRequests();
	long temp[]=new long[3];
	long test[]= {4,2,1};
	int i=0;
	
	for(LoanRequestEntity entity :loanList)
	{
	temp[i]=entity.getLoanRequestId();
	i++;
	}
	assertArrayEquals(test, temp);
	dao.deleteById(3L);
	dao.deleteById(4L);
	
}


}

