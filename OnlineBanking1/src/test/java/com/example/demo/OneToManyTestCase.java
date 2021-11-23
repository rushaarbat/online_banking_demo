package com.example.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.layer2.Payee;
import com.example.demo.layer3.PayeeRepoImpl;

@SpringBootTest
public class OneToManyTestCase {
	
//	@Autowired
//	PayeeRepoImpl payeeRepoImpl;
	
	@Test
	public void insertPayee() {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("MyJPA"); //persistence.xml is read here 

	System.out.println("Entity Manager Factory : "+entityManagerFactory);

	EntityManager entityManager = entityManagerFactory.createEntityManager();
		//ctrl+shift+M

		System.out.println("Entity Manager : "+entityManager);

		EntityTransaction transaction = entityManager.getTransaction();
	transaction.begin();
		Payee payee= new Payee();
		payee.setBeneficiaryAccNo(99);
		payee.setBeneficiaryName("Ramesh");
		payee.setNickname("Ramu");
		entityManager.persist(payee); //generate the insert query for us 
		   transaction.commit();
		//payeeRepoImpl.insertPayee(payee);
	}
	
	
	

}
