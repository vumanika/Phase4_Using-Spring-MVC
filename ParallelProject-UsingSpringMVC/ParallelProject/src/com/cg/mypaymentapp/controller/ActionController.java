package com.cg.mypaymentapp.controller;

import java.math.BigDecimal;
import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.service.WalletService;

@Controller
public class ActionController {

	@Autowired(required=true)
	private WalletService walletservice; 
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public ModelAndView create1(@Valid @ModelAttribute("customer") Customer customer,BindingResult res)
	{
		try {
			if(res.hasErrors())return new ModelAndView("create");
			customer=walletservice.createAccount(customer.getName(), customer.getMobileNo(), customer.getWallet().getBalance());
			ModelAndView modelAndView = new ModelAndView("loginsuccessful","customer",customer);
			return modelAndView;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("errorPage");
	}
	@RequestMapping(value="/checkingbalance1",method=RequestMethod.GET)
	public ModelAndView display1(@ModelAttribute("customer") Customer customer)
	{
		try {
			customer=walletservice.showBalance(customer.getMobileNo());
			ModelAndView modelAndView = new ModelAndView("display","customer",customer);
			return modelAndView;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("errorPage");
	}
	@RequestMapping(value="/withdraw1",method=RequestMethod.GET)
	public ModelAndView withdraw1(@ModelAttribute("customer") Customer customer)
	{
		try {
			customer=walletservice.withdrawAmount(customer.getMobileNo(),customer.getWallet().getBalance());
			ModelAndView modelAndView = new ModelAndView("display","customer",customer);
			return modelAndView;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("errorPage");
	}
	@RequestMapping(value="/deposit1",method=RequestMethod.GET)
	public ModelAndView deposit1(@ModelAttribute("customer") Customer customer)
	{
		try {
			customer=walletservice.depositAmount(customer.getMobileNo(),customer.getWallet().getBalance());
			ModelAndView modelAndView = new ModelAndView("display","customer",customer);
			return modelAndView;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("errorPage");
	}
	@RequestMapping(value="/fundtransfer1",method=RequestMethod.GET)
	public ModelAndView fundtransfer1(@RequestParam("sourcemobileNo")String sourcemobileNo,@RequestParam("desmobileNo")String desmobileNo,@RequestParam("balance")BigDecimal balance)
	{
		try {
			Customer customer=walletservice.fundTransfer(sourcemobileNo, desmobileNo, balance);
			ModelAndView modelAndView = new ModelAndView("display","customer",customer);
			return modelAndView;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("errorPage");
	}
	
	
}
