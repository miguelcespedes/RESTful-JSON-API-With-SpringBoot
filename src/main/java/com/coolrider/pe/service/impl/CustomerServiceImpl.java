package com.coolrider.pe.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.coolrider.pe.model.Customer;
import com.coolrider.pe.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService
{

	@Override
	public HashMap<String, Object> getCustomers()
	{

		List<Customer> customerList = new ArrayList();
		customerList.add(new Customer(42848585, "Miguel", "Céspedes", "miguelcespedes@outlook.com"));
		customerList.add(new Customer(47046135, "Tamara", "Nuñez", "tamaranp@outlook.com"));

		HashMap<String, Object> format = new HashMap();
		format.put("total", customerList.size());
		format.put("elements", customerList);

		return format;
	}

}
