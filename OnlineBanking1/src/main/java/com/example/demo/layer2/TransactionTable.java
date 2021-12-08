package com.example.demo.layer2;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="Transactiontable04")
public class TransactionTable {
	@Id
	@GeneratedValue
	private int transactionId;
	private String modeOfTransaction;
	
	private double amountTransferred;
	private String remark;
	private LocalDate transactionDate;
	
	//**********mapping*******************//
	
	@ManyToOne
	private AccountDetails accountDetails;
	
    @OneToOne
    private Payee payee;
	
	
//******************************************//	
	
	
	public TransactionTable() {
		super();
	}
	
	
	public TransactionTable(int transactionId, String modeOfTransaction, double amountTransferred, String remark,
			LocalDate transactionDate, AccountDetails accountDetails, Payee payee) {
		super();
		this.transactionId = transactionId;
		this.modeOfTransaction = modeOfTransaction;
		this.amountTransferred = amountTransferred;
		this.remark = remark;
		this.transactionDate = transactionDate;
		this.accountDetails = accountDetails;
		this.payee = payee;
	}
	
	//----getters and setters-----//

	public Payee getPayee() {
		return payee;
	}

	public void setPayee(Payee payee) {
		this.payee = payee;
	}
	
	public AccountDetails getAccountDetails() {
		return accountDetails;
	}

	public void setAccountDetails(AccountDetails accountDetails) {
		this.accountDetails = accountDetails;
	}
	
	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getModeOfTransaction() {
		return modeOfTransaction;
	}
	public void setModeOfTransaction(String modeOfTransaction) {
		this.modeOfTransaction = modeOfTransaction;
	}
	
	public double getAmountTransferred() {
		return amountTransferred;
	}
	public void setAmountTransferred(double amountTransferred) {
		this.amountTransferred = amountTransferred;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public LocalDate getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}
	
}
