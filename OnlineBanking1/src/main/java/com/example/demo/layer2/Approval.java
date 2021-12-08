package com.example.demo.layer2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="approval04")
public class Approval {
	@Id
	@GeneratedValue
	private int SRN;   //pk
	private String approvalStatus;
	  //private int custID;
	// private int adminID
	
	/***************mapping********************/
	
	@OneToOne 
	private CustomerDetails customerDetails;
	
	@ManyToOne
	@JoinColumn ( name = "adminID")
	private Approval approval;
	
	
	/**********setter getter *******************/
	

	public Approval getApproval() {
		return approval;
	}
	public void setApproval(Approval approval) {
		this.approval = approval;
	}
	
	
	public CustomerDetails getCustomerDetails() {
		return customerDetails;
	}
	public void setCustomerDetails(CustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}
	
	
	public int getSRN() {
		return SRN;
	}
	public void setSRN(int sRN) {
		SRN = sRN;
	}
	
	
	public String getApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Approval [SRN=" + SRN + ", approvalStatus=" + approvalStatus + ", customerDetails=" + customerDetails
				+ ", approval=" + approval + ", getApproval()=" + getApproval() + ", getCustomerDetails()="
				+ getCustomerDetails() + ", getSRN()=" + getSRN() + ", getApprovalStatus()=" + getApprovalStatus()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	

}
