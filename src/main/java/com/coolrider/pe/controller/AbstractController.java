
package com.coolrider.pe.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.bazaarvoice.jolt.Chainr;
import com.bazaarvoice.jolt.JsonUtil;
import com.bazaarvoice.jolt.JsonUtilImpl;
import com.bazaarvoice.jolt.JsonUtils;
import com.coolrider.pe.model.BusinessResponse;
import com.coolrider.pe.model.GenericMap;
import com.coolrider.pe.util.BusinessData;
import com.coolrider.pe.util.CommonUtil;
import com.coolrider.pe.util.HttpStatusData;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AbstractController
{
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private static final JsonUtil util = new JsonUtilImpl();

	public ResponseEntity<GenericMap> adaptToTemplateResponse(Object data)
	{

		try
		{
			List<Object> chainrSpecJSON = JsonUtils.classpathToList("/tpl/response.json");
			Chainr chainr = Chainr.fromSpec(chainrSpecJSON);

			GenericMap inputJSON = CommonUtil.easyMap("message", data);
			logger.info("../inputJSON: {}", JsonUtils.toJsonString(inputJSON));

			GenericMap transformedOutput = new ObjectMapper().convertValue(chainr.transform(inputJSON), GenericMap.class);
			logger.info("../transformedOutput: {}", JsonUtils.toJsonString(transformedOutput));

			return new ResponseEntity<>(transformedOutput, HttpStatus.OK);

		} catch (Exception e)
		{
			logger.error("../Exception: {}", e.getMessage());

		}
		return null;

	}

}