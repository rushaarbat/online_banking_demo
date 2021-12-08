package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.layer2.AccountDetails;
import com.example.demo.layer2.Payee;
import com.example.demo.layer3.AccountDetailsRepoImpl;
import com.example.demo.layer3.PayeeRepoImpl;

@SpringBootTest
public class PayeeCURDTest {
	
@Autowired
AccountDetailsRepoImpl accountDetailsRepoImpl;
	
@Autowired
PayeeRepoImpl payeeRepoImpl;

@Test
public void InsertPayee(){

Payee payee = new Payee();

payee.setBeneficiaryName("Surybhan");
payee.setNickname("surya");

payeeRepoImpl.insertPayee(payee);

}

@Test
void SelectPayeeTest() {
	
	Payee payee = payeeRepoImpl.selectPayee(31);
	
		System.out.println("Payee  Beneficiary Accound Number  is : "+ payee.getBeneficiaryAccNo());
		System.out.println("Payee beneficiary name  : "+ payee.getBeneficiaryName());
		System.out.println("Payee beneficiary Nick name  : "+ payee.getNickname());
		
}


public void SelectAllPayeeTest() {
	List <Payee>payeeList;
	payeeList = payeeRepoImpl.selectAllPayees();
	for (Payee payee : payeeList) {
		System.out.println("Payee  Beneficiary Accound Number  is : "+ payee.getBeneficiaryAccNo());
		System.out.println("Payee beneficiary name  : "+ payee.getBeneficiaryName());
		System.out.println("Payee beneficiary Nick name  : "+ payee.getNickname());
		
	}
}
@Test
public void updatePayeeTest() {
	Payee payee = new Payee();
	payee.setBeneficiaryAccNo(31);
	payee.setBeneficiaryName("lakhan");
	payee.setNickname("lakhuu");
	payeeRepoImpl.updatePayee(payee);

	
}

@Test
void deletePayeeTest(){
	Payee payee = new Payee();
	payeeRepoImpl.deletePayee(31);
	
}
//	*************** one Account Having many payees****************************//

@Test
void PayeeAccountDetailsInsertToExistingAccount()
{
	AccountDetails accountDetails=accountDetailsRepoImpl.selectAccountDetails(16);
	Payee payee = new Payee();

	payee.setBeneficiaryName("Rushabh");
	payee.setNickname("Rushi");
	payee.setAccountDetails(accountDetails);

	payeeRepoImpl.insertPayee(payee);

}

}
