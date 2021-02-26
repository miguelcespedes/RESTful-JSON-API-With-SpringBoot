package com.coolrider.pe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coolrider.pe.entity.CustomersEntity;
import com.coolrider.pe.model.GenericMap;
import com.coolrider.pe.repository.CustomersRepository;

@Service
public class CustomersService
{

	@Autowired
	private CustomersRepository customersRepository;

	public GenericMap getCustomers()
	{
		List<CustomersEntity> list = customersRepository.findAll();
		GenericMap genericMap = new GenericMap();
		genericMap.put("total", list.size());
		genericMap.put("elements", list);
		return genericMap;
	}

}
