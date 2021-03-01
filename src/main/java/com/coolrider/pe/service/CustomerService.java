package com.coolrider.pe.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coolrider.pe.mapper.CustomerMapper;
import com.coolrider.pe.model.GenericMap;

/**
 * <h1>CustomersService</h1>
 *
 * @author Miguel Céspedes
 * @version 1.0
 * @since february 2021
 */
@Service
public class CustomerService
{
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private CustomerMapper customerMapper;

	/* READ */
	public GenericMap getCustomers(String id)
	{
		GenericMap map = new GenericMap();
		List<GenericMap> customersList = new ArrayList<GenericMap>();
		if (id == null)
			customersList = customerMapper.findAll();
		else
			customersList = customerMapper.findById(id);
		map.put("total", customersList.size());
		logger.info("CustomerService/total: {}", customersList.size());
		map.put("elements", customersList);
		logger.info("CustomerService/elements: {}", customersList);
		return map;
	}

}
