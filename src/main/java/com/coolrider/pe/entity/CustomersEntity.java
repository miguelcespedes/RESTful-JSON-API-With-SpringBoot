package com.coolrider.pe.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_customers")
public class CustomersEntity
{
	private int customerId;
	private String identifierType;
	private String identifierValue;
	private String fullName;
	private String address;

	public CustomersEntity()
	{
	}

	public CustomersEntity(int customerId, String identifierType, String identifierValue, String fullName, String address)
	{
		super();
		this.customerId = customerId;
		this.identifierType = identifierType;
		this.identifierValue = identifierValue;
		this.fullName = fullName;
		this.address = address;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getCustomerId()
	{
		return customerId;
	}

	public void setCustomerId(int customerId)
	{
		this.customerId = customerId;
	}

	public String getIdentifierType()
	{
		return identifierType;
	}

	public void setIdentifierType(String identifierType)
	{
		this.identifierType = identifierType;
	}

	public String getIdentifierValue()
	{
		return identifierValue;
	}

	public void setIdentifierValue(String identifierValue)
	{
		this.identifierValue = identifierValue;
	}

	public String getFullName()
	{
		return fullName;
	}

	public void setFullName(String fullName)
	{
		this.fullName = fullName;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

}
