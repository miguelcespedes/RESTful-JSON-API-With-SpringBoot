
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
import com.coolrider.pe.util.BusinessData;
import com.coolrider.pe.util.HttpStatusData;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AbstractController
{
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private static final JsonUtil util = new JsonUtilImpl();

	public ResponseEntity<Object> adaptToTemplateResponse(Object data)
	{

		try
		{
			List<Object> chainrSpecJSON = JsonUtils.classpathToList("/tpl/response.json");
			logger.info("AbstractController/responseTransformation/chainrSpecJSON: {}", chainrSpecJSON);
			logger.info("AbstractController/responseTransformation/chainrSpecJSON/size: {}", chainrSpecJSON.size());

			Chainr chainr = Chainr.fromSpec(chainrSpecJSON);
			logger.info("AbstractController/responseTransformation/chainr: {}", chainr);
			
			//Map<String, Object> inputJSON = util.classpathToMap( "/tpl/request.json" );
			BusinessResponse model = new BusinessResponse();
			model.setStatus(HttpStatusData.OK.getValue());
			model.setCode(BusinessData.SUCCESS.getValue());
			model.setInformation(BusinessData.SUCCESS.getDescription());
			model.setMessagge(data);						
			Map<String, Object> inputJSON = new ObjectMapper().convertValue(model, Map.class);
			logger.info("AbstractController/responseTransformation/inputJSON: {}", inputJSON.toString());

			Object transformedOutput = chainr.transform(inputJSON);
			logger.info(
					"AbstractController/responseTransformation/transformedOutput: {}",
					JsonUtils.toJsonString(transformedOutput)
			);

			return new ResponseEntity<>(transformedOutput, HttpStatus.OK);

		} catch (Exception e)
		{
			logger.error("AbstractController/responseTransformation/Exception: {}", e.getMessage());

		}
		return null;

	}

}