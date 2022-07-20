package com.bank.main;


import java.util.Random;
import java.util.Scanner;

import java.sql.SQLException;
import com.bank.model.Bank;
import com.bank.model.Transaction;
import com.bank.service.BankService;

public class BankMain {
	public static void main(String[] args) throws SQLException{
		Scanner s=new Scanner(System.in);
		System.out.println("1. Customer");
		System.out.println("2. Employee");
		System.out.println("Enter your choice");
		int choice=s.nextInt();
		switch(choice) {
		case 1:
			System.out.println("1.Create bank account");
			System.out.println("2.login account");
			System.out.println("Enter your choice");
			int choice1=s.nextInt();
			
			switch(choice1)
			{
			case 1:
			Scanner s1=new Scanner(System.in);
		
			System.out.println("Enter the name:");
			String name=s1.nextLine();
			s.nextLine();
			System.out.println("Enter the phone: ");
			String phone=s1.nextLine();
			
			System.out.println("Enter the Password");
			String pass=s1.nextLine();
			System.out.println("enter aadharNo");
			int aadhar=s1.nextInt();
			System.out.println("minimum balance amount");
			float amount=s.nextFloat();
			Bank b=new Bank();
			b.setName(name);
			b.setPhone(phone);
			b.setPass(pass);
			b.setAadharNo(aadhar);
			b.setAmount(amount);
			BankService bankService=new BankService();
			int resultt1=bankService.loginDetails(b);
			if(resultt1!=0) {
				System.out.println("Bank details added successfully");
			}else {
				System.out.println("Bank details not added successfully");
			}
		break;
			
		case 2:
			System.out.println("login page");
			s.nextLine();
			System.out.println("Enter loginId");
			String loginId=s.nextLine();
			System.out.println("enter pass");
		     String pass1=s.nextLine();
		     		     
		     Bank d=new Bank();
			  d.setName(loginId);
			  d.setPass(pass1);
				BankService bankService1=new BankService();
				boolean status3=bankService1.loginAccount(d);
		     if(status3==true)
		     {
		    	 System.out.println("login");
		    	 System.out.println("1.view balance");
					System.out.println("2.withdrawl amount");
					System.out.println("3.Deposit");
					System.out.println("4.Transfer Amount");
					System.out.println("ente ur choice");
					int choice3=s.nextInt();
		    	 switch(choice3){
		     case 1:
					System.out.println(" view balance");
					System.out.println("enter acc no:");
					int accb=s.nextInt();
					
					Bank b1=new Bank();
					b1.setAccNo(accb);
					
					BankService bs=new BankService();
					float status4=bs.viewBalance(b1);
					if(status4>=0)
						System.out.println("balance amount:-"+" "+status4);
					
					else {
					    System.out.println("Invalid credentials");
					}
						
					break;
				case 2:
					System.out.println("withdrawl");
					System.out.println("enter acc no:");
					int an=s.nextInt();
					System.out.println("Enter amount");
					int am=s.nextInt();
					Bank bw=new Bank();
					bw.setAccNo(an);
					bw.setAmount(am);
					BankService bsw=new BankService();
					float result=bsw.withDrawlAmount(bw);
					if(result!=0) {
					System.out.println("Withdrawl amount is:-"+result);
					bw.setWithdrawl(result);
					
				    float resulty=bsw.withdrawlAmount2(bw);
				    float bamount=resulty-result;
				    bw.setBalance(bamount);
				    System.out.println("balance amount:"+bamount);
				    int st=bsw.updateBankBalance(bw);
				    System.out.println("status:-"+st);
				    
				    
					}
					else {
						System.out.println("please check account number or balance amount ");
					}
					break;
				case 3:
					System.out.println("deposit");
					System.out.println("enter acc no");
					int ad=s.nextInt();
					System.out.println("enter amount");
					int amd=s.nextInt();
					Bank bd=new Bank();
				   bd.setAccNo(ad);
				   bd.setAmount(amd);
				   BankService bsd=new BankService();
				  int result8= bsd.updateDepositamount(bd);
				  if(result8==1)
				  {
					  System.out.println("Amount is added to balance");
					  float result5=bsd.withdrawlAmount2(bd);
					  float bamount2=result5+amd;
					  bd.setBalance(bamount2);
					  System.out.println(bamount2);
					  int result7=bsd.setDepositAmount(bd);
					  if(result7==1)
					  {
						  System.out.println("updated");
					  }
				  }
				  else {
					  System.out.println("Please check account number");
				  }
				
		    	 } }else {
		    	 System.out.println("INVALID CREDENTIALS");
		    	 
		    	 }
			break;
		}
			break;
		
			
		case 2:
			System.out.println("welcome employee");
			s.nextLine();
			System.out.println("Enter name of employee");
			String ename1=s.nextLine();
			
			System.out.println("pass");
			String epass1=s.nextLine();
			Bank be=new Bank();
			be.setEname(ename1);
			be.setEpass(epass1);
			BankService bs=new BankService();
			boolean status=bs.employeeDetails(be);
			if(status==true)
			{
				System.out.println("login");
				System.out.println("1.Approve or reject the register customer accounts");
				System.out.println("2.Transaction Info of customers");
				System.out.println("enter ur choice");
				int choicee=s.nextInt();
				switch(choicee) {
				case 1:
					System.out.println("Registered customer details");
					BankService bs1=new BankService();
					String result=bs1.approvalAccount(be);					
					if(result!=null)
					{
						System.out.println(result);
						System.out.println("set status of the accounts to approve");
						s.nextLine();
						System.out.println("enter the accountant name of checking");
						 String aname=s.nextLine();
						System.out.println("enter 0 for approve or 1 for active the registered customer accounts");
						int staus1=s.nextInt();
						Bank ba=new Bank();
						ba.setStatus(staus1);
						ba.setName(aname);
						BankService bas=new BankService();
						int results=bas.updateStatus(ba);					
					if(results==1) {
						System.out.println("approved the account "+aname);
						System.out.println("setting the account number");
						Random account=new Random();
						int accounts=account.nextInt(1000000000);
						ba.setAccNo(accounts);
						BankService baa=new BankService();
		                int resulty=baa.setAccNo(ba);
		                if(resulty==1) {
						System.out.println(aname +" "+"account number:-"+" "+accounts);
		                }
					
					else {
						System.out.println("Rejected the account"+aname);
					}
					}}
			
					break;
				case 2:
					System.out.println("Customers transaction Details");
					BankService bs2=new BankService();
					Transaction ts=new Transaction();
					String btd=bs2.transactionDetails(ts);
					System.out.println(btd);
					break;
				}
			}
			else {
				System.out.println("invalid credintials");
			}
		
		}s.close();}
	}