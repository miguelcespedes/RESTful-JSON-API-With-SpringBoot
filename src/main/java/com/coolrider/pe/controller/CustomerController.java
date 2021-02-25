package com.coolrider.pe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coolrider.pe.service.CustomerService;

@RestController
@RequestMapping("customer")
public class CustomerController 
{

	@Autowired
	private CustomerService service;
	
	@GetMapping(produces = "application/json")
	public Object read()
	{
		return service.getCustomer();
	}

}