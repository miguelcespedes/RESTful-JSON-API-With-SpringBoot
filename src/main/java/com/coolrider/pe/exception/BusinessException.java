package com.coolrider.pe.exception;

public class BusinessException extends Exception
{
	private static final long serialVersionUID = 1L;
	private String messageId;
	private String businessCode;
	private String businessMessage;

	public BusinessException(String messageId, String businessCode, String businessMessage)
	{
		super();
		this.messageId = messageId;
		this.businessCode = businessCode;
		this.businessMessage = businessMessage;
	}

	public String getMessageId()
	{
		return messageId;
	}

	public String getBusinessCode()
	{
		return businessCode;
	}

	public String getBusinessMessage()
	{
		return businessMessage;
	}

	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}
}