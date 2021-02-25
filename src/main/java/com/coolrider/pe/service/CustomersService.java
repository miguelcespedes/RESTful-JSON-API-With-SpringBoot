package com.coolrider.pe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.coolrider.pe.model.CustomersModel;
import com.coolrider.pe.model.GenericMap;

@Service
public class CustomersService implements ICustomersService
{

	@Override
	public GenericMap getCustomers()
	{

		List<CustomersModel> customerList = new ArrayList<CustomersModel>();
		customerList.add(new CustomersModel(42848585, "Miguel", "Céspedes", "miguelcespedes@outlook.com"));
		customerList.add(new CustomersModel(47046135, "Tamara", "Nuñez", "tamaranp@outlook.com"));
		customerList.add(new CustomersModel(12345678, "Juan", "Perez", "jperez@outlook.com"));

		GenericMap format = new GenericMap();
		format.put("total", customerList.size());
		format.put("elements", customerList);

		return format;
	}

}
