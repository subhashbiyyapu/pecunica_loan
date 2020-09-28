package com.cg.loanservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="LOANREQUESTTABLE")
public class LoanRequestEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loan_request_generator")
	@SequenceGenerator(name="loan_request_generator", sequenceName = "loanrequst_seq", allocationSize=1,initialValue=3)
	 
	@Column(name="LOANREQUESTID")
	 private Long loanRequestId;
	@Column(name="ACCOUNTNO")
	 private Long accountNo;
	@Column(name="AMOUNT")
	 private Double amount;
	@Column(name="LOANTYPE")
	 private String loanType;
	@Column(name="RATEOFINTEREST")
	 private Double rateOfInterest;
	@Column(name="TENURE")
	 private Integer tenure;
	@Column(name="CREDITSCORE")
	 private Integer creditScore;
	@Column(name="LOANSTATUS")
	 private String loanStatus;
	@Column(name="EMPLOYEEID")
	 private Long EmployeeId;
	 
	public LoanRequestEntity() {
		super();
		// TODO Auto-generated constructor stub
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
		EmployeeId = employeeId;
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
		return EmployeeId;
	}

	public void setEmployeeId(Long employeeId) {
		EmployeeId = employeeId;
	}
	
	

}
