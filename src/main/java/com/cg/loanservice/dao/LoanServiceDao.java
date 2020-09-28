package com.cg.loanservice.dao;

import java.util.List;


import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.loanservice.entity.LoanRequestEntity;

@Repository
public interface LoanServiceDao extends JpaRepository<LoanRequestEntity, Long> {
	

List<LoanRequestEntity> findByLoanStatus(String loanStatus,Sort sort);
}
