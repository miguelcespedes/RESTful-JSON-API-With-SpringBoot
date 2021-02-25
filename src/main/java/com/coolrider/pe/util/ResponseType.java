package com.coolrider.pe.util;

public enum ResponseType
{
	SUCCESS(true), BUSINESS(false), FAILURE(false);
	private boolean value;

	private ResponseType(boolean value)
	{
		this.value = value;
	}
}