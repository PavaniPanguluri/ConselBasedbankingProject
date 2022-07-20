package com.bank.model;

public class Transaction {
	private float balance;
	private float deposit;
	private float withdrawl;
	private int taccNo;
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public float getDeposit() {
		return deposit;
	}
	public void setDeposit(float deposit) {
		this.deposit = deposit;
	}
	@Override
	public String toString() {
		return "Transaction [balance=" + balance + ", deposit=" + deposit + ", withdrawl=" + withdrawl + ", taccNo="
				+ taccNo + "]";
	}
	public float getWithdrawl() {
		return withdrawl;
	}
	public void setWithdrawl(float withdrawl) {
		this.withdrawl = withdrawl;
	}
	public int getTaccNo() {
		return taccNo;
	}
	public void setTaccNo(int taccNo) {
		this.taccNo = taccNo;
	}

}
