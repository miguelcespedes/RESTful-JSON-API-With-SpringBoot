package com.coolrider.pe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coolrider.pe.model.GenericMap;
import com.coolrider.pe.service.CustomersService;

@RestController

public class CustomersController extends AbstractController
{

	@Autowired
	private CustomersService customersService;

	@GetMapping("/customers")
	public ResponseEntity<GenericMap> AllCustomers()
	{
		return adaptToTemplateResponse(customersService.getAllCustomers());
	}

	@GetMapping("/customers/{id}")
	public ResponseEntity<GenericMap> CustomerByIndex(@PathVariable Integer id)
	{
		return adaptToTemplateResponse(customersService.getCustomerByIndex(id));
	}

}