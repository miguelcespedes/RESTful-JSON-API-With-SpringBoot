package com.coolrider.pe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coolrider.pe.model.GenericMap;
import com.coolrider.pe.service.CustomersService;

/**
 * <h1>CustomersController</h1>
 *
 * @author Miguel Céspedes
 * @version 1.0
 * @since february 2021
 */
@RestController
public class CustomersController extends AbstractController
{

	@Autowired
	private CustomersService customersService;

	@RequestMapping(value = "${ms.resource.customer}", method = RequestMethod.GET)
	public ResponseEntity<GenericMap> getCustomers() throws Exception
	{
		return adaptToTemplateResponse(customersService.getCustomers(0));
	}

	@RequestMapping(value = "/${ms.resource.customer}/{id}", method = RequestMethod.GET)
	public ResponseEntity<GenericMap> getCustomerById(@PathVariable Integer id) throws Exception
	{
		return adaptToTemplateResponse(customersService.getCustomers(id));
	}

}