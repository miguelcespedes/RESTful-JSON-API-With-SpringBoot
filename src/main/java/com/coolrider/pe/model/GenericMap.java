package com.coolrider.pe.model;

import java.util.HashMap;

import com.bazaarvoice.jolt.JsonUtils;

public class GenericMap extends HashMap<String, Object>
{
	@Override
	public String toString()
	{
		return JsonUtils.toJsonString(this);
				
	}
}
