package com.coolrider.pe.service.impl;

import org.springframework.stereotype.Service;

import com.coolrider.pe.model.Customer;
import com.coolrider.pe.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService
{

	@Override
	public Customer getCustomer()
	{
		Customer customer = new Customer();
		customer.setId(1);
		customer.setFirstName("Miguel");
		customer.setLastName("Céspedes");
		customer.setEmail("miguelcespedes@outlook.com");
		return customer;
	}

}
