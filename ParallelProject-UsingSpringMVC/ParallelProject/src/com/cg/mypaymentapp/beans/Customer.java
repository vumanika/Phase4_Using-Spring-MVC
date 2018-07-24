package com.cg.mypaymentapp.beans;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
public class Customer {
	@NotEmpty
	private String name;
	@Id
	@NotEmpty
	private String mobileNo;
	@Embedded
	private Wallet wallet;
	public Customer(String name2, String mobileno2, Wallet wallet2) {
		super();
		this.name = name2;
		this.mobileNo = mobileno2;
		this.wallet = wallet2;
	}
	public Customer() {
		super();		
		this.name = "";
		this.mobileNo = "";
		this.wallet =null;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Wallet getWallet() {
		return wallet;
	}
	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	@Override
	public String toString() {
		return "Customer :name=" + name + "mobileNo=" + mobileNo
				+ "wallet=" + wallet ;
	}
	
}
