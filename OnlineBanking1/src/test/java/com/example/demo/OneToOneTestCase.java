package com.example.demo;

import java.time.LocalDate;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.layer2.AccountDetails;
import com.example.demo.layer2.Approval;
import com.example.demo.layer2.CustomerDetails;
import com.example.demo.layer3.AccountDetailsRepoImpl;
import com.example.demo.layer3.CustomerDetailsRepoImpl;
import com.example.demo.layer3.TransactionTableRepoImpl;
@SpringBootTest
public class OneToOneTestCase {
	
	
	@Test
	public void insertCustomerDetails() {
		
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("MyJPA"); //persistence.xml is read here 

		System.out.println("Entity Manager Factory : "+entityManagerFactory);

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		//ctrl+shift+M

		System.out.println("Entity Manager : "+entityManager);

		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		CustomerDetails customerDetails = new CustomerDetails(); //new/blank entity object 
		customerDetails.setCustId(12);
		customerDetails.setTitle("Mr");
		customerDetails.setFirstName("Chetan");
		customerDetails.setMiddleName("Shrikrushna");
		customerDetails.setLastName("ARBAT");
		customerDetails.setMobileNumber(8975348428l);
		customerDetails.setEmail("rushabh97@gmail.com");
		customerDetails.setAadharNumber(28466464464l);
		customerDetails.setDob(LocalDate.of(1997, 9, 27));
		customerDetails.setFatherName("Shrikrushna Arbat");
		customerDetails.setInitialAmount(1000);
		customerDetails.setResidLine1("SBI Colony ");
		customerDetails.setResidLine2("near Wagh society");
		customerDetails.setResidLankmark("Temple");
		customerDetails.setResidState("MH");
		customerDetails.setResidCity("Shegaon");
		customerDetails.setResidPincode(444203);
		customerDetails.setPerLine1("Krishana Nagar");
		customerDetails.setPerLine2("near apl ghar society");
		customerDetails.setPerLankmark("Bridge");
		customerDetails.setPerState("MH");
		customerDetails.setPerCity("Pune");
		customerDetails.setPerPincode(412216);
		customerDetails.setOccupationType(" Soft Engg");
		customerDetails.setIncomeSource("Job");
		customerDetails.setGrossAnnualIncome(300000);
		customerDetails.setDebitCard("Y");
		customerDetails.setOptNetBank("Y");
		
	
	    entityManager.persist(customerDetails); //generate the insert query for us 
	   transaction.commit();
		
		
	}
//	@Autowired
//	AccountDetailsRepoImpl AccountDetailsRepoImpl;
//	
	@Test
	public void insertAccountDetails() {
		
	EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("MyJPA"); //persistence.xml is read here 

	System.out.println("Entity Manager Factory : "+entityManagerFactory);

	EntityManager entityManager = entityManagerFactory.createEntityManager();
		//ctrl+shift+M

		System.out.println("Entity Manager : "+entityManager);

		EntityTransaction transaction = entityManager.getTransaction();
	transaction.begin();

		AccountDetails accountDetails = new AccountDetails();
		accountDetails.setAccountNumber(3333);;
		accountDetails.setUserID("ABC12");;
		accountDetails.setCreatedOn(LocalDate.of(2020, 9, 27));
        accountDetails.setAccountStatus("pending");
        accountDetails.setAccountLock("@123");
        accountDetails.setLoginPassword("123#");
        accountDetails.setTransactionPassword("TRR@12");
        accountDetails.setAccountType("Saving Type");
        accountDetails.setAccountBalance(12000);
       // AccountDetailsRepoImpl.insertAccountDetails(accountDetails);

	    entityManager.persist(accountDetails); //generate the insert query for us 
	   transaction.commit();
		
}
	
	@Test
	public void insertApprovalDetails() {
		
	EntityManagerFactory entityManagerFactory = 
			Persistence.createEntityManagerFactory("MyJPA"); //persistence.xml is read here 

	System.out.println("Entity Manager Factory : "+entityManagerFactory);

	EntityManager entityManager = entityManagerFactory.createEntityManager();
	//ctrl+shift+M

	System.out.println("Entity Manager : "+entityManager);

	EntityTransaction transaction = entityManager.getTransaction();
	transaction.begin();
	
	Approval approval = new Approval(); 
	
	approval.setSRN(34567);
	approval.setApprovalStatus("Pending");

    entityManager.persist(approval); //generate the insert query for us 
   transaction.commit();
}
	
	@Test
	public void assignExistingCustomerDetailsToExistingAccountDetails()
	{
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("MyJPA"); //persistence.xml is read here 

		System.out.println("Entity Manager Factory : "+entityManagerFactory);

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		//ctrl+shift+M

		System.out.println("Entity Manager : "+entityManager);

		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();


		CustomerDetails customerDetails  = entityManager.find(CustomerDetails.class, 12);
		AccountDetails accountDetails  = entityManager.find(AccountDetails.class, 2222);

		customerDetails.setAccountDetails(accountDetails);// are we setting the FK?
		accountDetails.setCustomerDetails(customerDetails); // are we setting the FK?

				entityManager.merge(customerDetails);
				entityManager.merge(accountDetails);

		transaction.commit();		

	}
	
	
	@Test
	public void assignExistingCustomerDetailsToExistingApprovalDetails()
	{
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("MyJPA"); //persistence.xml is read here 

		System.out.println("Entity Manager Factory : "+entityManagerFactory);

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		//ctrl+shift+M

		System.out.println("Entity Manager : "+entityManager);

		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();


		CustomerDetails customerDetails  = entityManager.find(CustomerDetails.class, 12);
		Approval approvalDetails  = entityManager.find(Approval.class, 34567);

		customerDetails.setApproval(approvalDetails);// are we setting the FK?
		approvalDetails.setCustomerDetails(customerDetails); // are we setting the FK?

				entityManager.merge(customerDetails);
				entityManager.merge(approvalDetails);

		transaction.commit();		

	}
	
	
}
