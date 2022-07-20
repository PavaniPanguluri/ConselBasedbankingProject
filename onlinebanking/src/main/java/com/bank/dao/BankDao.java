package com.bank.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bank.model.Bank;
import com.bank.model.Transaction;
public class BankDao {
	int count;
	ArrayList<Bank> as=new ArrayList<Bank>();
	ArrayList<Transaction> as1=new ArrayList<Transaction>();
	public int insertLoginDetails(Bank bankDetails) throws SQLException {
		// jdbc code to add bank
		String url="jdbc:mysql://localhost:3306/banking";
		String user="root";
		String password="Pavani@228";
		String sql="INSERT INTO customer VALUES(?,?,?,?,?,?,?,?,?)";
		
		
			Connection con=DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1,bankDetails.getName());
			pstmt.setString(2, bankDetails.getPhone());
			pstmt.setInt(3, bankDetails.getAadharNo());
			pstmt.setString(4,bankDetails.getPass());
			pstmt.setInt(5, bankDetails.getStatus());
			pstmt.setFloat(6,bankDetails.getAmount());
			pstmt.setInt(7,bankDetails.getAccNo());
			pstmt.setFloat(8,bankDetails.getDeposit());
			pstmt.setFloat(9,bankDetails.getWithdrawl());
			
			int status = pstmt.executeUpdate();return status;}
			
	     public boolean selectLogindetails(Bank d) throws SQLException
	     {
	    	//BankMain m=new BankMain();
	    	 String url="jdbc:mysql://localhost:3306/banking";
	 		String user="root";
	 		String password="Pavani@228";
	 		String d1="Select name,pass from customer where name='"+d.getName()+"'";
	    	 Connection c=DriverManager.getConnection(url, user, password);
	    	 Statement st=c.createStatement();
	    	 ResultSet rs=st.executeQuery(d1);
	    	 String name2="";
	    	 String pass2="";
				while(rs.next())
					{
					name2=rs.getString("name");
					pass2=rs.getString("pass");
					}
				   if(((d.getName()).equals(name2))&&((d.getPass()).equals(pass2)))
			
				{ return true;
				}
				else {
			     return false;
			     

				}}
	    
	     public boolean viewEmployeeDetails(Bank be) throws SQLException
	     {
	    	 Connection c1=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","Pavani@228");
	    	 Statement st1=c1.createStatement();
	    	 ResultSet rs1=st1.executeQuery("Select * from employee");
	    	 
	    	 String name2="";
	    	 String pass2="";
				while(rs1.next())
					{
					name2=rs1.getString("ename");
					pass2=rs1.getString("epass");
					
					}
				   if(((be.getEname()).equals(name2))&&((be.getEpass()).equals(pass2)))
			
				{ return true;
				}
				else {
			     return false;
			     

				}
	     }
	     public String approval(Bank be) throws SQLException
	     {   Connection c1=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","Pavani@228");
    	 Statement st1=c1.createStatement();
    	 ResultSet rs1=st1.executeQuery("Select * from customer");
    	 String name2="";
    	 String pass2="";
    	 int aadhar = 0;
    	 int status=0;
    	 String phone = "";
			while(rs1.next())
				{
				name2=rs1.getString(1);
				phone=rs1.getString(2);
				aadhar=rs1.getInt(3);
				status=rs1.getInt(5); 	
			Bank b3=new Bank();
			b3.setName(name2);
			b3.setAadharNo(aadhar);
			b3.setPass(pass2);
			b3.setPhone(phone);
			b3.setStatus(status);
			
				as.add(b3);}
			return as.toString();
	     }
	     public int updateStatusacounts(Bank b) throws SQLException
	     {
	      Connection c1=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","Pavani@228");
    	  Statement st1=c1.createStatement(); 
    	  String aname1= b.getName();
    	  int status1=b.getStatus();
         int rs1=st1.executeUpdate("update customer set status='"+status1+"' where name='"+aname1+"'");
    	 return rs1;
   	 }
	     public int updateAccNo(Bank bn) throws SQLException
	     {
	    	 Connection c2=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","Pavani@228");
	    	 String aname1= bn.getName();
	     	 int acc11=bn.getAccNo();
	     	 Statement st1=c2.createStatement();
	    	 int rs2=st1.executeUpdate("update customer set accno='"+acc11+"' where name='"+aname1+"'");
				
	     return rs2;}
	     public float balance(Bank bg) throws SQLException
	     {
	    	 Connection c2=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","Pavani@228");
	    	 Statement s=c2.createStatement();
	    	 int accnn=0;
			 float bal=0;
	    	 ResultSet rs1=s.executeQuery("Select accno,balance from customer where accno="+bg.getAccNo()+"");
			
			while(rs1.next())
			{
				accnn=rs1.getInt("accno");
				bal=rs1.getFloat("balance");
			}
			if((bg.getAccNo())==(accnn))
			{
	    	 return bal;}
			else { return count;}	
	     }
	     public float withDrawl(Bank bg) throws SQLException
	     {
	    	 Connection c2=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","Pavani@228");
	    	 Statement s=c2.createStatement();
	    	 ResultSet rs1=s.executeQuery("Select accno,balance from customer where accno="+bg.getAccNo()+"");
	    	 int accw=0;
	    	 int amount1=0;
	    	 
	    	 float amounttt=bg.getAmount();
	    	 while(rs1.next())
	    	 {
	    		 accw=rs1.getInt("accno");
	    		 amount1=rs1.getInt("balance");
	    		
	    		 }
	    	 
	    	 if((bg.getAccNo()==accw)&&(bg.getAmount()<=amount1)){
	    		 return amounttt;
	    		 
	    	 }else {
			return count;}
	    		 
	    	 
	     
      }
	     public float getBalanceMethod(Bank bew) throws SQLException {
	    	  Connection c2=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","Pavani@228");
		    	 Statement s=c2.createStatement();
		    	 
				 float amount=0;   
				    
		    	 ResultSet rs1=s.executeQuery("select *from customer where accno="+bew.getAccNo()+"");
		    	 while(rs1.next()) {
		    		 amount=rs1.getInt("balance");
		    	 }
		    	 return amount;
	    	
			}
	     public int updateWithdrawlBalance(Bank bn) throws SQLException {
	    	 Connection c2=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","Pavani@228");
	     	 int acc11=bn.getAccNo();
	     	
	     	 Statement st1=c2.createStatement();
	     	 int rs2=st1.executeUpdate("update customer set balance="+bn.getBalance()+",withdrawl="+bn.getAmount() +" where accno="+acc11+"");
	     	if (rs2!=0)
	     		{
	     		
	     		Statement st2=c2.createStatement();
	     	     int rs1=st2.executeUpdate("insert into accounts(accno,balance,withdrawl) values("+bn.getAccNo()+","+bn.getBalance()+","+bn.getAmount()+")");
	     		return rs1;
	     		}
	     	else {
	     		return 0;
	     	}
	     		
	     }
	     public int deposit(Bank bv) throws SQLException {
	    	 Connection c2=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","Pavani@228");
	    	 Statement s=c2.createStatement();
	    	 int accn=0;
	    	 ResultSet rs1=s.executeQuery("Select accno from customer where accno="+bv.getAccNo()+"");
	         while(rs1.next())
	         {
	        	 accn=rs1.getInt("accno");
	         }
	         if((bv.getAccNo())==(accn))
	         {
	        	return 1; 
	         }else {
	    	 return 0;}

		}
	     public int updateDepositBalance(Bank bn) throws SQLException {
	    	 Connection c2=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","Pavani@228");
	     	 
	     	float balance=bn.getBalance();
	     	float amount1=bn.getAmount(); 
	     	 Statement st1=c2.createStatement();
	     	 int rs2=st1.executeUpdate("update customer set balance="+balance+",deposit="+amount1+" where accno="+bn.getAccNo()+"");
	     	if(rs2!=0)
	     	{
	     		Statement st2=c2.createStatement();
	     	     int rs1=st2.executeUpdate("insert into accounts(accno,balance,deposit) values("+bn.getAccNo()+","+bn.getBalance()+","+bn.getAmount()+")");
	     		return rs1;
	     		
	     	}
	     	else {
	     		return 0;
	     	}
	     	
	     }
	     public String transactionDetails(Transaction t) throws SQLException
	     {
	    	 Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","Pavani@228");
	    	 Statement s=cn.createStatement();
	    	 ResultSet rs1=s.executeQuery("select * from accounts");
	    	float balance1=0;
	    	float deposit1=0;
	    	float withdrawl1=0;
	    	int accno1=0;
	    	while(rs1.next())
	    	{
	    		balance1=rs1.getFloat(2);
	    		deposit1=rs1.getFloat(3);
	    		withdrawl1=rs1.getFloat(4);
	    		accno1=rs1.getInt(1);
	    		
	    	Transaction t2=new Transaction();
	    	t2.setTaccNo(accno1);
	    	t2.setBalance(balance1);
	    	t2.setDeposit(deposit1);
	    	t2.setWithdrawl(withdrawl1);
	    as1.add(t2);
	    	}	    	 return as1.toString();
	     }
}
	    	 
	     
