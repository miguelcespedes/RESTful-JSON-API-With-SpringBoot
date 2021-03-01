package com.coolrider.pe.exception;

/**
 * <h1>BusinessException</h1>
 *
 * @author Miguel Céspedes
 * @version 1.0
 * @since february 2021
 */
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
