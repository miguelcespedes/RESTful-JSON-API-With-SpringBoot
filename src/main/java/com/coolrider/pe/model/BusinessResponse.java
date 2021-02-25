package com.coolrider.pe.model;

import java.util.HashMap;

public class BusinessResponse
{
	private int status;
	private int code;
	private String information;
	private Object messagge;

	public int getStatus()
	{
		return status;
	}

	public void setStatus(int status)
	{
		this.status = status;
	}

	public int getCode()
	{
		return code;
	}

	public void setCode(int code)
	{
		this.code = code;
	}

	public String getInformation()
	{
		return information;
	}

	public void setInformation(String information)
	{
		this.information = information;
	}

	public Object getMessagge()
	{
		return messagge;
	}

	public void setMessagge(Object messagge)
	{
		this.messagge = messagge;
	}

	@Override
	public String toString()
	{
		return "BusinessResponse [status=" + status + ", code=" + code + ", information=" + information + ", messagge="
				+ messagge + "]";
	}

}
