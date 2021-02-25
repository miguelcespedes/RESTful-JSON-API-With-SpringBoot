
package com.coolrider.pe.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.bazaarvoice.jolt.Chainr;
import com.bazaarvoice.jolt.JsonUtils;
import com.coolrider.pe.model.BusinessResponse;
import com.coolrider.pe.util.BusinessData;
import com.coolrider.pe.util.HttpStatusData;

public abstract class AbstractController
{
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/*
	 * @Autowired
	 * 
	 * @Qualifier("mapBean") private HashMap<String, Object> mapBean;
	 */
	public ResponseEntity<Object> adaptToTemplateResponse(Object data)
	{
		// logger.info("AbstractController/adaptToTemplateResponse/mapBean: {}", mapBean);
		messageTransformation();

		BusinessResponse response = new BusinessResponse();
		response.setStatus(HttpStatusData.OK.getValue());
		response.setCode(BusinessData.SUCCESS.getValue());
		response.setInformation(BusinessData.SUCCESS.getDescription());
		response.setMessagge(data);

		logger.info("AbstractController/adaptToTemplateResponse/response: {}", response.toString());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	public void messageTransformation()
	{
		try
		{
			List chainrSpecJSON = JsonUtils.classpathToList("/jolt/spec.json");
			logger.info("AbstractController/load2021/chainrSpecJSON: {}", chainrSpecJSON);

			Chainr chainr = Chainr.fromSpec(chainrSpecJSON);
			logger.info("AbstractController/load2021/chainr: {}", chainr);

			Object inputJSON = JsonUtils.classpathToObject("/jolt/input.json");
			logger.info("AbstractController/load2021/inputJSON: {}", inputJSON);

			Object transformedOutput = chainr.transform(inputJSON);
			logger.info("AbstractController/load2021/transformedOutput: {}", JsonUtils.toJsonString(transformedOutput));

		} catch (Exception e)
		{
			logger.error("AbstractController/load2021/Exception: {}", e.getMessage());
		}
	}

}