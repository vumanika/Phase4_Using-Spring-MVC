package com.cg.mypaymentapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.mypaymentapp.beans.Customer;

@Controller
public class URIController {

	@RequestMapping(value="/")
	public String getIndex()
	{
		return "index";
	}
	

	@RequestMapping(value="/create")
	public String getCreate()
	{
		return "create";
	}
	

	@RequestMapping(value="/checkingbalance")
	public String getCheckbalance()
	{
		return "checkingbalance";
	}
	@RequestMapping(value="/withdraw")
	public String getWithdraw()
	{
		return "withdraw";
	}
	@RequestMapping(value="/deposit")
	public String getDeposit()
	{
		return "deposit";
	}
	@RequestMapping(value="/fundtransfer")
	public String getfundtransfer()
	{
		return "fundtransfer";
	}
	
	
	@ModelAttribute("customer")
	public Customer gerCustomer() {
		return new Customer();
	}
	
}
