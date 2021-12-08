package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo.layer2.Approval;
import com.example.demo.layer2.CustomerDetails;
import com.example.demo.layer3.ApprovalRepoImpl;
import com.example.demo.layer3.CustomerDetailsRepoImpl;

@SpringBootTest
public class ApprovalCRUDTest {
	
@Autowired
ApprovalRepoImpl approvalRepoImpl;

@Autowired
CustomerDetailsRepoImpl custDetRepoImpl;

@Test
public void InsertAdmin(){

Approval approval = new Approval();

approval.setApprovalStatus("Pending");

approvalRepoImpl.insertApproval(approval);

}


@Test
void SelectApprovalTest() {
	
	Approval approval = approvalRepoImpl.selectApproval(29);
	
		System.out.println(" Approval service refrence number  is : "+ approval.getSRN());
		System.out.println("accountDetails User Id : "+ approval.getApprovalStatus());
		System.out.println("Customer Details  : "+ approval.getCustomerDetails());
}


public void SelectAllApprovalTest() {
	List <Approval>approvalList;
	approvalList = approvalRepoImpl.selectAllApproval();
	for (Approval approval : approvalList) {
		System.out.println("approval service refrence number is : "+ approval.getSRN());
		System.out.println("Approval Status is : "+ approval.getApprovalStatus());
	}
}
@Test
public void updateApprovalTest() {
	Approval approval = new Approval();
	approval.setSRN(29);
	approval.setApprovalStatus("waiting..");
	
}

@Test
 public void deleteApprovalTest(){
	Approval approval = new Approval();
	approvalRepoImpl.deleteApproval(29);
}
//****************one to one******************************//
@Test
public void InsertArovalToExistingCustomer() {
	
	Approval approval= approvalRepoImpl.find(Approval.class,29);
	CustomerDetails customerDetails =custDetRepoImpl.find(CustomerDetails.class,19);
	
	approval.setCustomerDetails(customerDetails);
	customerDetails.setApproval(approval); 
	
	approvalRepoImpl.merge(customerDetails);
}
}
