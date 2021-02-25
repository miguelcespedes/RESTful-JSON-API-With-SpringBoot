package com.coolrider.pe.util;

public enum BusinessData
{

	// Business Message
	SUCCESS(1001, "Success"), //
	FAILURE(9001, "Failure");//

	private final int value;
	private final String description;

	BusinessData(int value, String description)
	{
		this.value = value;
		this.description = description;
	}

	public int getValue()
	{
		return value;
	}

	public String getDescription()
	{
		return description;
	}

	@Override
	public String toString()
	{
		return value + " " + description;
	}

	public static BusinessData getByValue(int value)
	{
		for (BusinessData status : values())
		{
			if (status.value == value)
				return status;
		}
		throw new IllegalArgumentException("Invalid status code: " + value);
	}
}