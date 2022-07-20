package com.bank.service;


import java.sql.SQLException;


import com.bank.dao.BankDao;
import com.bank.model.Bank;
import com.bank.model.Transaction;

public class BankService {
	 
	public int loginDetails(Bank bank) throws SQLException {
		BankDao bDao=new BankDao();
		int result=bDao.insertLoginDetails(bank);
		return result;
	}
	public boolean loginAccount(Bank d) throws SQLException{
		BankDao bDao1=new BankDao();
		boolean result2=bDao1.selectLogindetails(d);
	      return result2;	
	}
	public float viewBalance(Bank b) throws SQLException
	{ BankDao bd2=new BankDao();
		float result=bd2.balance(b);
		return result;}
	public int depositAmount(Bank b)
	{
		return 0;
		
	}
	public float withDrawlAmount(Bank bew) throws SQLException
	{ BankDao bdw=new BankDao();
	  float resultts=bdw.withDrawl(bew);
		return resultts;}
	
	public boolean employeeDetails(Bank b) throws SQLException
	{
		BankDao bd=new BankDao();
		boolean result=bd.viewEmployeeDetails(b);
		return result;
	}
	public String approvalAccount(Bank b) throws SQLException {
		BankDao bd1=new BankDao();
		String result=bd1.approval(b);
		
		return result;
		
	}
	public int updateStatus(Bank bas) throws SQLException {
		BankDao bu=new BankDao();
		int result=bu.updateStatusacounts(bas);
		return result;
	}

	public int setAccNo(Bank ba) throws SQLException {
		BankDao bdac=new BankDao();
		int res1=bdac.updateAccNo(ba);
		return res1;
	}
	
	
	public float withdrawlAmount2(Bank bw) throws SQLException {
		
		BankDao bdw2=new BankDao();
		float results=bdw2.getBalanceMethod(bw);
		return results;
		}
	
	public int updateBankBalance(Bank bw) throws SQLException {
		BankDao bdw3=new BankDao();
		int result=bdw3.updateWithdrawlBalance(bw);
		return result;
		
	}
	public int updateDepositamount(Bank br) throws SQLException
	{
		BankDao bdd=new BankDao();
		int result=bdd.deposit(br);
		return result;
	}
	public int setDepositAmount(Bank ko) throws SQLException {
		BankDao bdds=new BankDao();
		int result=bdds.updateDepositBalance(ko);
		return result;
	}
	public String transactionDetails(Transaction be) throws SQLException
	{
		BankDao bd=new BankDao();
		String bs=bd.transactionDetails(be);
		return bs;}
	}
	
	
	
	

