package com.coolrider.pe.model;

import java.io.Serializable;

public class CustomerModel implements Serializable
{
	private static final long serialVersionUID = 1L;

	private int customer_id;
	private String identifier_type;
	private String identifier_value;
	private String full_name;
	private String address;

	public int getCustomer_id()
	{
		return customer_id;
	}

	public void setCustomer_id(int customer_id)
	{
		this.customer_id = customer_id;
	}

	public String getIdentifier_type()
	{
		return identifier_type;
	}

	public void setIdentifier_type(String identifier_type)
	{
		this.identifier_type = identifier_type;
	}

	public String getIdentifier_value()
	{
		return identifier_value;
	}

	public void setIdentifier_value(String identifier_value)
	{
		this.identifier_value = identifier_value;
	}

	public String getFull_name()
	{
		return full_name;
	}

	public void setFull_name(String full_name)
	{
		this.full_name = full_name;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	@Override
	public String toString()
	{
		return "CustomerModel [customer_id=" + customer_id + ", identifier_type=" + identifier_type
				+ ", identifier_value=" + identifier_value + ", full_name=" + full_name + ", address=" + address + "]";
	}

}