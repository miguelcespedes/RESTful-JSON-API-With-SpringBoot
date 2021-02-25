package com.coolrider.pe.model;

import java.util.HashMap;
import com.google.gson.Gson;

public class GenericMap extends HashMap<String, Object>
{
	@Override
	public String toString()
	{
		return new Gson().toJson(this);
	}
}
