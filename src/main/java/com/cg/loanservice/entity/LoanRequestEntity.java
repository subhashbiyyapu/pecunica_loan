package com.cg.loanservice.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


import com.cg.loanservice.validator.AccountNumber;



@Entity
@Table(name="LOANREQUESTTABLE")
public class LoanRequestEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loan_request_generator")
	@SequenceGenerator(name="loan_request_generator", sequenceName = "loanrequst_seq", allocationSize=1,initialValue=3)
	 
	@Column(name="LOANREQUESTID")
	 private Long loanRequestId;
	
	
	@AccountNumber
	@Column(name="ACCOUNTNO")
	 private Long accountNo;
	
	@NotNull
	@Min(value = 10000,message="amount must be between 10000 and 2000000")
	@Max(value = 2000000,message="amount must be between 10000 and 2000000")
	@Column(name="AMOUNT")
	 private Double amount;
	
	@NotNull
	@Column(name="LOANTYPE")
	 private String loanType;
	
	@NotNull
	@Min(value = 4,message="rate of interest must be between 4 and 15")
	@Max(value = 15,message="rate of interest must be between 4 and 15")
	@Column(name="RATEOFINTEREST")
	 private Double rateOfInterest;
	
	
	@Min(value = 12,message="tenure must be between 12  and 240 months")
	@Max(value = 240,message="tenure must be between 12  and 240 months")
	@Column(name="TENURE")
	 private Integer tenure;
	
	@Min(value = 0,message="credit score must be between 0  and 999 months")
	@Max(value = 999,message="credit score must be between 0  and 999 months")
	@Column(name="CREDITSCORE")
	 private Integer creditScore;
	
	@Column(name="LOANSTATUS")
	 private String loanStatus;
	
	@Column(name="EMPLOYEEID")
	 private Long employeeId;
	 
	public LoanRequestEntity() {
		super();
		
	}
	
	public LoanRequestEntity(Long loanRequestId, Long accountNo, Double amount, String loanType, Double rateOfInterest,
			Integer tenure, Integer creditScore, String loanStatus, Long employeeId) {
		super();
		this.loanRequestId = loanRequestId;
		this.accountNo = accountNo;
		this.amount = amount;
		this.loanType = loanType;
		this.rateOfInterest = rateOfInterest;
		this.tenure = tenure;
		this.creditScore = creditScore;
		this.loanStatus = loanStatus;
		this.employeeId = employeeId;
	}



	public Long getLoanRequestId() {
		return loanRequestId;
	}
	public void setLoanRequestId(Long loanRequestId) {
		this.loanRequestId = loanRequestId;
	}
	public Long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public Double getRateOfInterest() {
		return rateOfInterest;
	}
	public void setRateOfInterest(Double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}
	public Integer getTenure() {
		return tenure;
	}
	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}
	public Integer getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(Integer creditScore) {
		this.creditScore = creditScore;
	}
	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}
	public String getLoanStatus() {
		return loanStatus;
	}
	
	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	
	

}
