package com.coolrider.pe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coolrider.pe.model.GenericMap;
import com.coolrider.pe.service.CustomerService;

@RestController
@RequestMapping("customer")
public class CustomerController extends AbstractController
{

	@Autowired
	private CustomerService businessMessagge;

	@GetMapping(produces = "application/json")
	public ResponseEntity<GenericMap> read()
	{
		return adaptToTemplateResponse(businessMessagge.getCustomers());
	}

}