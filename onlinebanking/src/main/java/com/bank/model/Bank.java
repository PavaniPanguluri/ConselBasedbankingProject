package com.bank.model;

public class Bank {
	private String phone ;
	private String name;
	private String pass;
	private int aadharNo;
	private int accNo;
	private float balance;
	private float amount;
	private String ename;
	private String epass;
	private int status;
	private float deposit;
	private float withdrawl;
	
	
//	public Bank(String string, int i, int j, String string2, int k, int l, int m, int n, int o) {
//		// TODO Auto-generated constructor stub
//	}
//	public Bank() {
//		// TODO Auto-generated constructor stub
//	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(int aadharNo) {
		this.aadharNo = aadharNo;
	}
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEpass() {
		return epass;
	}
	public void setEpass(String epass) {
		this.epass = epass;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public float getDeposit() {
		return deposit;
	}
	public void setDeposit(float deposit) {
		this.deposit = deposit;
	}
	public float getWithdrawl() {
		return withdrawl;
	}
	public void setWithdrawl(float withdrawl) {
		this.withdrawl = withdrawl;
	}
	@Override
	public String toString() {
		return "Bank [phone=" + phone + ", name=" + name + ", aadharNo=" + aadharNo + ", status=" + status + "]";
	}
	
	
}