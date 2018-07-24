package com.cg.mypaymentapp.service;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Wallet;
import com.cg.mypaymentapp.exception.InvalidInputException;
import com.cg.mypaymentapp.repo.WalletRepo;
@Component
public class WalletServiceImpl implements WalletService {
	private Map<String, Customer> data = new HashMap<String, Customer>();
@Autowired
	WalletRepo servicedao;
@Transactional
	@Override
	public Customer createAccount(String name, String mobileno, BigDecimal amount) throws SQLException {

		/*if (validatemobile(mobileno))*/ {
			Customer cu = new Customer(name, mobileno, new Wallet((amount)));
			servicedao.save(cu);
			return cu;
		} /*else {
			System.out.println("Invalid number!!!\n Enter 10 digit valid number");
			Scanner sc1 = new Scanner(System.in);
			return createAccount(name, sc1.next(), amount);
		}*/

	}

	public boolean validatemobile(String str) {
		String patterns = "[1-9][0-9]{9}";
		if (str.matches(patterns)) {
			return true;
		} else {
			return false;
		}
	}

	Scanner sc = new Scanner(System.in);
	@Transactional
	@Override
	public Customer showBalance(String mobileno) throws SQLException {
		Customer customer;

		customer = servicedao.findOne(mobileno);
		if (customer != null)
			return customer;
		else {
			String k = sc.next();
			return showBalance(k);

		}

	}
	@Transactional
	@Override
	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount) throws SQLException {
		Customer cu1 = servicedao.findOne(sourceMobileNo);
		Customer cu2 = servicedao.findOne(targetMobileNo);
		BigDecimal bg1 = amount;
		Wallet w = cu1.getWallet();
		Wallet w1 = cu2.getWallet();
		BigDecimal balance = w.getBalance();
		BigDecimal balance1 = w1.getBalance();
		cu1.setWallet(new Wallet(balance.subtract(amount)));
		Customer cu3 = servicedao.save(cu1);
		cu2.setWallet(new Wallet(balance1.add(amount)));
		Customer cu4 = servicedao.save(cu2);
		return cu1;
	}
	@Transactional
	@Override
	public Customer depositAmount(String mobileNo, BigDecimal amount1) throws SQLException {
		Customer cu1 = servicedao.findOne(mobileNo);
		BigDecimal bg1 = amount1;
		Wallet w = cu1.getWallet();
		BigDecimal balance = w.getBalance();
		BigDecimal deposit = balance.add(amount1);
		cu1.setWallet(new Wallet(deposit));
		Customer cu2 = servicedao.save(cu1);
		return cu2;
	}
	@Transactional
	@Override
	public Customer withdrawAmount(String mobileNo1, BigDecimal amount2) throws SQLException {
		Customer cu2 = servicedao.findOne(mobileNo1);
		BigDecimal bg1 = amount2;
		BigDecimal bg2 = new BigDecimal(0);
		Wallet w = cu2.getWallet();
		BigDecimal balance = w.getBalance();
		BigDecimal withdraw = balance.subtract(amount2);
		if (withdraw.compareTo(bg2) > 0) {
			cu2.setWallet(new Wallet(withdraw));
			Customer cu3 = servicedao.save(cu2);
			return cu3;
		} else {
			System.out.println("Insufficient Balance");
			return null;
		}
	}
}
