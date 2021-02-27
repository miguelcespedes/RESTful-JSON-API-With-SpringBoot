package com.coolrider.pe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coolrider.pe.entity.CustomersEntity;
import com.coolrider.pe.model.GenericMap;
import com.coolrider.pe.repository.CustomersRepository;
import com.coolrider.pe.util.CommonUtil;

/**
 * <h1>CustomersService</h1>
 *
 * @author Miguel Céspedes
 * @version 1.0
 * @since february 2021
 */
@Service
public class CustomersService
{

	@Autowired
	private CustomersRepository customersRepository;

	/* CREATE */
	public GenericMap registerCustomer(CustomersEntity customersEntity) throws Exception
	{
		customersRepository.save(customersEntity);
		return CommonUtil.easyMap("success", true);
	}

	/* READ */
	public GenericMap getCustomers(Integer id) throws Exception
	{
		GenericMap genericMap = new GenericMap();
		List<CustomersEntity> customersList = new ArrayList<CustomersEntity>();
		if (id.equals(0))
		customersList = customersRepository.findAll();
		else
		customersList.add(customersRepository.findById(id).get());
		genericMap.put("total", customersList.size());
		genericMap.put("elements", customersList);
		return genericMap;
	}

	/* DELETE */
	public GenericMap deleteCustomer(Integer id) throws Exception
	{
		customersRepository.deleteById(id);
		return CommonUtil.easyMap("success", true);
	}

}
