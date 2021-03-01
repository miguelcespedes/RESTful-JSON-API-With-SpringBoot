package com.coolrider.pe.model;

import java.util.HashMap;

import com.bazaarvoice.jolt.JsonUtils;

/**
 * <h1>GenericMap</h1>
 *
 * @author Miguel Céspedes
 * @version 1.0
 * @since february 2021
 */
public class GenericMap extends HashMap<String, Object>
{

	private static final long serialVersionUID = 1L;

	@Override
	public String toString()
	{
		return JsonUtils.toJsonString(this);

	}
}
