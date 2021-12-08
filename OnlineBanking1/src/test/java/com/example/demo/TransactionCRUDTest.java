package com.example.demo;



import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.layer2.AccountDetails;
import com.example.demo.layer2.Payee;
import com.example.demo.layer2.TransactionTable;
import com.example.demo.layer3.AccountDetailsRepoImpl;
import com.example.demo.layer3.PayeeRepoImpl;
import com.example.demo.layer3.TransactionTableRepoImpl;

@SpringBootTest
public class TransactionCRUDTest {

	@Autowired
	TransactionTableRepoImpl transTableRepoImpl;
	
	@Autowired
	AccountDetailsRepoImpl accountDetailsRepoImpl;
	
	@Autowired
	PayeeRepoImpl payRepoImpl;

	@Test
	public void InsertTransaction() {

		LocalDate lds = LocalDate.of(2021, 7, 7);
		TransactionTable transTable = new TransactionTable();

		transTable.setModeOfTransaction("UPI");
		transTable.setAmountTransferred(2000.8);
		transTable.setRemark("Done");
		transTable.setTransactionDate(lds);

		transTableRepoImpl.insertTransactionTable(transTable);

	}


@Test
void SelectTransactionTest() {
	
	TransactionTable transTable = transTableRepoImpl.selectTransactionTable(31);
	
		System.out.println("transaction ID   is : "+ transTable.getTransactionId());
		System.out.println(" Mode Of Transaction is : "+ transTable.getModeOfTransaction());
		System.out.println(" Account Number Is : "+ transTable.getAccountDetails());
		System.out.println("  Beneficiary Account Number Is : "+ transTable.getPayee());s
		System.out.println(" Amount Transferred Is : "+ transTable.getAmountTransferred());
		System.out.println(" remark  Is : "+ transTable.getRemark());
		System.out.println(" TransactionDate Is : "+ transTable.getTransactionDate());
		
}

@Test
public void SelectAllTransactionTest() {
	List<TransactionTable>transList;
	transList = transTableRepoImpl.selectAllTransactionTable();
	for (TransactionTable transTable : transList) {
		System.out.println("transaction ID   is : "+ transTable.getTransactionId());
		System.out.println(" Mode TransactionTableOf Transaction is : "+ transTable.getModeOfTransaction());
		System.out.println(" Account Number Is : "+ transTable.getAccountDetails());
		System.out.println("  Beneficiary Account Number Is : "+ transTable.get);
		System.out.println(" Amount Transferred Is : "+ transTable.getAmountTransferred());
		System.out.println(" remark  Is : "+ transTable.getRemark());
		System.out.println(" TransactionDate Is : "+ transTable.getTransactionDate());
		
	}
}
@Test
public void updateTransactionTest() {
	
	LocalDate lds = LocalDate.of(2021, 9, 7);
	
	TransactionTable transTable = new TransactionTable();
	transTable.setModeOfTransaction("UPI");
	transTable.setAmountTransferred(2000.8);
	transTable.setRemark("Done");
	transTable.setTransactionDate(lds);

	
	
}

@Test
void deleteTransactionTest(){
	TransactionTable transTable = new TransactionTable();
	transTableRepoImpl.deleteTransactionTable(41);;
}

//************************One Account Having Many Transaction*********************************//

 @Test
  public void InsertTransactionsToExistingAccount(){
	 
	 LocalDate lds = LocalDate.of(2021, 7, 7);
	 
	 AccountDetails accountDetails = accountDetailsRepoImpl.find(AccountDetails.class, 32);
	 TransactionTable transTable = new TransactionTable();
	 transTable.setModeOfTransaction("Debit Card");
		transTable.setAmountTransferred(2000.8);
		transTable.setRemark("Done");
		transTable.setTransactionDate(lds);

		transTableRepoImpl.insertTransactionTable(transTable);

	 
	 
  }

}
